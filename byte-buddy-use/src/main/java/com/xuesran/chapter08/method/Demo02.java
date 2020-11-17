package com.xuesran.chapter08.method;

import com.xuesran.chapter08.service.First;
import com.xuesran.chapter08.service.Second;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.DefaultMethodCall;
import net.bytebuddy.matcher.ElementMatchers;

import java.io.File;
import java.io.IOException;

/**
 * 调用默认方法
 * @author xueshun
 */
public class Demo02 {

    public static void main(String[] args) throws IOException {
        new ByteBuddy()
                .subclass(Object.class)
                .implement(First.class)
                .implement(Second.class)
                .method(ElementMatchers.named("qux")).intercept(DefaultMethodCall.prioritize(First.class))
                .make();
    }
}
