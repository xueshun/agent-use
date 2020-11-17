package com.xuesran.chapter13.test;

import com.xuesran.chapter13.paramBinder.StringValue;

public class ToStringInterceptor {

    public static String makeString(@StringValue("Hello!") String value){
        return value;
    }
}
