package com.xuesran.chapter07.test;

import com.xuesran.chapter07.interceptor.Forwarder;
import com.xuesran.chapter07.interceptor.ForwardingLoggerInterceptor;
import com.xuesran.chapter07.interceptor.MemoryDatabase;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.implementation.bind.annotation.Pipe;
import net.bytebuddy.matcher.ElementMatchers;

import java.io.File;
import java.io.IOException;

public class ForwardTest {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, IOException {
        /*MemoryDatabase load = */new ByteBuddy().subclass(MemoryDatabase.class)
                .method(ElementMatchers.<MethodDescription>named("load"))
                .intercept(MethodDelegation.withDefaultConfiguration()
                        .withBinders(Pipe.Binder.install(Forwarder.class))
                        .to(new ForwardingLoggerInterceptor(new MemoryDatabase())))
                .make().saveIn(new File("G://byte-buddy//chapter07"))
                /*.load(ForwardTest.class.getClassLoader())
                .getLoaded()
                .newInstance()*/;
       // load.load("ttt");

    }
}
