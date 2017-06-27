//
//  RNLogmatic.h
//  RNLogmatic
//
//  Created by Yann Pringault on 27/06/17.
//  Copyright © 2017 Yann Pringault. All rights reserved.
//

#ifndef RNLogmatic_h
#define RNLogmatic_h

#if __has_include(<React/RCTBridge.h>)
// React Native >= 0.40
#import <React/RCTBridge.h>
#else
// React Native <= 0.39
#import "RCTBridge.h"
#endif

#import <Logmatic/LMLogger.h>

@interface RNLogmatic : NSObject <RCTBridgeModule>

@end

#endif /* RNLogmatic_h */
