package com.xuesran.chapter07.test;

import com.xuesran.chapter07.interceptor.LoggerInterceptor;
import com.xuesran.chapter07.interceptor.MemoryDatabase;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;

public class LogTest {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        MemoryDatabase load = new ByteBuddy()
                .subclass(MemoryDatabase.class)
                .method(ElementMatchers.<MethodDescription>named("load")).intercept(MethodDelegation.to(LoggerInterceptor.class))
                .make()
                .load(LogTest.class.getClassLoader())
                .getLoaded()
                .newInstance();
        load.load("ttt");
    }
}
