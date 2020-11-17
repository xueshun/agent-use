package com.xuesran.chapter03.classload;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;

import java.io.File;
import java.io.IOException;

/**
 * 加载类
 *
 * @author xueshun
 */
public class Demo01 {

    public static void main(String[] args) throws IOException {
        new ByteBuddy()
                .subclass(Object.class)
                .make()
                //.saveIn(new File("G://byte-buddy//load-test"))
                .load(Demo01.class.getClassLoader(), ClassLoadingStrategy.Default.WRAPPER)
                .getLoaded();
    }
}
