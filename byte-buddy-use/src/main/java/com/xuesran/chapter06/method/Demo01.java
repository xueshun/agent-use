package com.xuesran.chapter06.method;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;

import java.io.File;
import java.io.IOException;

public class Demo01 {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, IOException {
        classMethod();
    }
    
    public static void attr() throws IllegalAccessException, InstantiationException {
        String s = new ByteBuddy()
                .subclass(Object.class)
                .name("example.Type")
                .make()
                .load(Demo01.class.getClassLoader())
                .getLoaded()
                .newInstance()
                .toString();
        System.out.println(s);
    }

    public static void method() throws IllegalAccessException, InstantiationException, IOException {
        Object o = new ByteBuddy()
                .subclass(Object.class)
                .name("example.Type")
                .method(ElementMatchers.<MethodDescription>named("toString")).intercept(FixedValue.value("Hello world"))
                .make()
                //.saveIn(new File("G://byte-buddy/chapter06"));
                .load(Demo01.class.getClassLoader())
                .getLoaded()
                .newInstance();
        System.out.println(o);
    }
    
    public static void classMethod() throws IllegalAccessException, InstantiationException, IOException {
       /* Foo foo = (Foo) */new ByteBuddy()
                .subclass(Foo.class)
                .method(ElementMatchers.<MethodDescription>isDeclaredBy(Foo.class)).intercept(FixedValue.value("One!"))
                .method(ElementMatchers.<MethodDescription>named("foo")).intercept(FixedValue.value("Two!"))
                .method(ElementMatchers.<MethodDescription>named("foo").and(ElementMatchers.takesArguments(1))).intercept(FixedValue.value("Three!"))
                .make()
                .saveIn(new File("G://byte-buddy//chapter06//class-method"))
                /*.load(Demo01.class.getClassLoader())
                .getLoaded()
                .newInstance()*/;
       // System.out.println(foo.bar());
    }
}


