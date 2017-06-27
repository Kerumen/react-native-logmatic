import { NativeModules } from 'react-native';

const { RNLogmatic } = NativeModules;

class Logmatic {

  init(apiKey) {
    return RNLogmatic.init(apiKey);
  }

  log(message, context = {}) {
    return RNLogmatic.log(message, context);
  }

  setMetas(metas) {
    return RNLogmatic.setMetas(metas);
  }

}

export default new Logmatic();
