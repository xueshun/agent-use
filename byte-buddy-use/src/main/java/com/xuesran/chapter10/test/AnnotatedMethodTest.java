package com.xuesran.chapter10.test;

import com.xuesran.chapter10.entity.AnnotatedMethod;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.StubMethod;
import net.bytebuddy.implementation.attribute.MethodAttributeAppender;
import net.bytebuddy.matcher.ElementMatchers;

import java.io.File;
import java.io.IOException;

/**
 * 属性附加器
 * @author xueshun
 */
public class AnnotatedMethodTest {
    public static void main(String[] args) throws IOException {
        new ByteBuddy().subclass(AnnotatedMethod.class)
                .method(ElementMatchers.named("bar"))
                .intercept(StubMethod.INSTANCE)
                .attribute(MethodAttributeAppender.ForInstrumentedMethod.EXCLUDING_RECEIVER)
                .make()
                .saveIn(new File("G://byte-buddy//chapter10//annotated-method"));
    }
}
