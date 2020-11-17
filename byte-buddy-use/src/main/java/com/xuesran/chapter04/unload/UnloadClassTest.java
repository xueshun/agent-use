package com.xuesran.chapter04.unload;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.pool.TypePool;

public class UnloadClassTest {

    public static void main(String[] args) throws NoSuchFieldException {
        TypePool typePool = TypePool.Default.ofPlatformLoader();
        new ByteBuddy()
                .redefine(typePool.describe("com.xuesran.chapter04.entity.Bar")
                                .resolve(),
                        ClassFileLocator.ForClassLoader.ofPlatformLoader())
                .defineField("qux", String.class)
                .make()
                .load(ClassLoader.getSystemClassLoader());
        //System.out.println(Bar.class.getDeclaredField("qux"));
    }
}

/*class Bar{

}*/
