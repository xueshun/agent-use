package com.xuesran.chapter13.test;

import com.xuesran.chapter12.allotter.ToStringAssigner;
import com.xuesran.chapter13.entity.StringTest;
import com.xuesran.chapter13.paramBinder.StringValueBinder;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;

import java.io.File;
import java.io.IOException;

public class StringValueTest {

    public static void main(String[] args) throws IOException, IllegalAccessException, InstantiationException {
        StringTest toString = new ByteBuddy().subclass(StringTest.class)
                .method(ElementMatchers.named("toString").and(ElementMatchers.isVarArgs()))
                .intercept(MethodDelegation.withDefaultConfiguration()
                        .withBinders(StringValueBinder.INSTANCE)
                        .to(ToStringInterceptor.class))
                .make()
                //.saveIn(new File("G://byte-buddy//chapter13"));
                .load(StringValueTest.class.getClassLoader())
                .getLoaded()
                .newInstance();
        System.out.println(toString.toString());
        toString.setName("111");
        System.out.println(toString.toString());
        //
    }
}


