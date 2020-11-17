package com.xuesran.chapter08.method;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.description.modifier.ModifierContributor;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy;
import net.bytebuddy.implementation.MethodCall;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * 调用特定方法
 *
 * @author xueshun
 */
public class Demo03 {

    public static void main(String[] args) throws NoSuchMethodException, IOException {
        new ByteBuddy()
                .subclass(Object.class, ConstructorStrategy.Default.NO_CONSTRUCTORS)
                .defineConstructor( Visibility.PUBLIC)
                .intercept(MethodCall.invoke(Object.class.getDeclaredConstructor()))
                .make()
                .saveIn(new File("G://byte-buddy//chapter08//demo03"));
    }
}
