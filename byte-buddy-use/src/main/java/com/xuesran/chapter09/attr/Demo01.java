package com.xuesran.chapter09.attr;

import com.xuesran.chapter09.entity.UserType;
import com.xuesran.chapter09.service.HelloWorldInterceptor;
import com.xuesran.chapter09.service.InstanceCreator;
import com.xuesran.chapter09.service.Interceptor;
import com.xuesran.chapter09.service.InterceptorAccessor;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.implementation.FieldAccessor;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;

public class Demo01 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class<? extends UserType> loaded = new ByteBuddy()
                .subclass(UserType.class)
                .method(ElementMatchers.not(ElementMatchers.isDeclaredBy(Object.class)))
                .intercept(MethodDelegation.toField("interceptor"))
                .defineField("interceptor", Interceptor.class, Visibility.PRIVATE)
                .implement(InterceptorAccessor.class)
                .intercept(FieldAccessor.ofBeanProperty())
                .make()
                .load(Demo01.class.getClassLoader())
                .getLoaded();

        InstanceCreator factory = new ByteBuddy()
                .subclass(InstanceCreator.class)
                .method(ElementMatchers.not(ElementMatchers.isDeclaredBy(Object.class)))
                .intercept(MethodDelegation.toConstructor(loaded))
                .make()
                .load(loaded.getClassLoader())
                .getLoaded()
                .newInstance();

        UserType userType = (UserType) factory.makeInstance();
        ((InterceptorAccessor) userType).setInterceptor(new HelloWorldInterceptor());
        userType.doSomething();
    }
}
