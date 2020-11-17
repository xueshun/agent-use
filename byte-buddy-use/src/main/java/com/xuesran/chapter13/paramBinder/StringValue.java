package com.xuesran.chapter13.paramBinder;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface StringValue {
    String value();
}
