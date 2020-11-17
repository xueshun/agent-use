package com.xuesran.chapter10.test;

import com.xuesran.chapter10.annotation.RuntimeDefinitionImpl;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.SuperMethodCall;
import net.bytebuddy.matcher.ElementMatchers;

import java.io.File;
import java.io.IOException;

public class AnnotationTest {
    public static void main(String[] args) throws IOException {
        testAnnotation1();
    }

    public static void testAnnotation1() throws IOException {
        new ByteBuddy()
                .subclass(Object.class)
                .annotateType(new RuntimeDefinitionImpl())
                .method(ElementMatchers.named("toString"))
                .intercept(SuperMethodCall.INSTANCE)
                .annotateMethod(new RuntimeDefinitionImpl())
                .defineField("foo", Object.class)
                .annotateField(new RuntimeDefinitionImpl())
                .make()
                .saveIn(new File("G://byte-buddy//chapter10//test-annotation"));
    }
}
