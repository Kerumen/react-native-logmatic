package com.kerumen.logmatic;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableNativeMap;
import com.facebook.react.bridge.ReadableType;

import io.logmatic.android.Logger;
import io.logmatic.android.LoggerBuilder;


public class RNLogmaticModule extends ReactContextBaseJavaModule {

    private Logger logger;

    public RNLogmaticModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "RNLogmatic";
    }

    @ReactMethod
    public void init(String apiKey) {
        logger = new LoggerBuilder().init(apiKey).build();
    }

    @ReactMethod
    public void setMetas(ReadableMap metas) {
        ReadableMapKeySetIterator iterator = metas.keySetIterator();
        while (iterator.hasNextKey()) {
            String key = iterator.nextKey();
            ReadableType type = metas.getType(key);
            switch (type) {
                case Boolean:
                    logger.addField(key, metas.getBoolean(key));
                    break;
                case Number:
                    logger.addField(key, metas.getDouble(key));
                    break;
                case String:
                    logger.addField(key, metas.getString(key));
                    break;
            }
        }
    }

    @ReactMethod
    public void log(String message, ReadableMap extra) {
        ReadableNativeMap context = (ReadableNativeMap) extra;
        logger.i(message, context.toHashMap());
    }

}
