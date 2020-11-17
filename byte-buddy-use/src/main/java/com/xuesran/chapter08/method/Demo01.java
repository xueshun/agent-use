package com.xuesran.chapter08.method;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy;

public class Demo01 {

    public static void main(String[] args) {

    }

    public static void callSuperMethod(){
        new ByteBuddy()
                .subclass(Object.class)
                .make();
    }

    public static void callSuperMethod01(){
        new ByteBuddy()
                .subclass(Object.class, ConstructorStrategy.Default.IMITATE_SUPER_CLASS)
                .make();
    }
}
