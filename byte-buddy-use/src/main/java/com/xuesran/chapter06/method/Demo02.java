package com.xuesran.chapter06.method;

import com.xuesran.chapter06.entity.Source;
import com.xuesran.chapter06.entity.Target;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;

/**
 * 委托方法调用
 *
 * @author xueshun
 */
public class Demo02 {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        String hello = new ByteBuddy()
                .subclass(Source.class)
                .method(ElementMatchers.<MethodDescription>named("hello")).intercept(MethodDelegation.to(Target.class))
                .make()
                .load(Demo02.class.getClassLoader())
                .getLoaded()
                .newInstance()
                .hello("World");
        System.out.println(hello);
    }

}




