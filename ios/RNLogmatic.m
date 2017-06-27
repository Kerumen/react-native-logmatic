//
//  RNLogmatic.m
//  RNLogmatic
//
//  Created by Yann Pringault on 27/06/17.
//  Copyright © 2017 Yann Pringault. All rights reserved.
//

#import "RNLogmatic.h"

@implementation RNLogmatic

RCT_EXPORT_MODULE();

RCT_EXPORT_METHOD(init:(NSString *)apiKey)
{
    LMLogger *logger = [LMLogger sharedLogger];
    [logger setKey:apiKey];
    [logger startLogger];
}

RCT_EXPORT_METHOD(setMetas:(NSDictionary *)meta)
{
    [[LMLogger sharedLogger] setMetas:meta];
}

RCT_EXPORT_METHOD(log:(NSString *)message context:(NSDictionary *)context)
{
    [[LMLogger sharedLogger] log:context withMessage:message];
}

@end
