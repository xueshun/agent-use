package com.xuesran.chapter01;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.NamingStrategy;
import net.bytebuddy.description.type.TypeDescription;

import java.io.File;
import java.io.IOException;

public class Demo01 {

    public static void main(String[] args) throws IOException {
        createByNamingSuffixingRandomError();
    }


    public static void createDefault() {
        // 会创建一个继承Object类型的类
        try {
            new ByteBuddy()
                    .subclass(Object.class)
                    .make()
                    .saveIn(new File("G://test"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createByName() {
        try {
            new ByteBuddy()
                    .subclass(Object.class)
                    .name("com.xuesran")
                    .make()
                    .saveIn(new File("G://byte-buddy//createByName"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * com.xuesran.Object
     * 当创建自己命名策略时，需要特别小心。
     * JVM就是使用名字来区分不同类型的，这正是为什么要避免命名冲突。
     * 如果需要定制命名行为，可以参考
     *
     * @see net.bytebuddy.implementation.auxiliary.AuxiliaryType.NamingStrategy.SuffixingRandom
     */
    public static void createByNamingStrategy() {
        try {
            new ByteBuddy()
                    .with(new NamingStrategy.AbstractBase() {
                        @Override
                        protected String name(TypeDescription typeDescription) {
                            return "com.xuesran" + typeDescription.getSimpleName();
                        }
                    })
                    .subclass(Object.class)
                    .make()
                    .saveIn(new File("G://byte-buddy//createByNamingStrategy"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createByNamingSuffixingRandom() {
        try {
            new ByteBuddy()
                    .with(new NamingStrategy.PrefixingRandom("com.xuesran"))
                    .subclass(Object.class)
                    .make()
                    .saveIn(new File("G://byte-buddy//createByNamingSuffixingRandom"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 你或许希望使用 new NamingStrategy.SuffixingRandom("suffix") 来自定义动态类型的命名策略。
     * 不是修改存储在 byteBuddy 变量中的实例，调用 withNamingStrategy 方法返回一个自定义的 ByteBuddy 实例，
     * 但是它却直接被丢弃了。结果，还是使用原来创建的默认配置来创建动态类型。
     */
    public static void createByNamingSuffixingRandomError(){
        ByteBuddy byteBuddy = new ByteBuddy();
        byteBuddy.with(new NamingStrategy.SuffixingRandom("com.xuesran.error"));
        try {
            byteBuddy.subclass(Object.class).make().saveIn(new File("G://byte-buddy//createByNamingSuffixingRandomError"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}