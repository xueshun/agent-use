package com.xuesran.chapter03.classload;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;

import java.io.File;
import java.io.IOException;

public class Demo02 {

    public static void main(String[] args) throws IOException {
        ByteBuddyAgent.install();
        Foo foo = new Foo();
        new ByteBuddy()
                .redefine(Bar.class)
                .name(Foo.class.getName())
                .make()
                .saveIn(new File("G://byte-buddy//demo02"));
                //.load(Foo.class.getClassLoader(), ClassReloadingStrategy.fromInstalledAgent());
        System.out.println(foo.m());
    }
}

class Foo {
    String m() {
        return "foo";
    }
}

class Bar {
    String m() {
        return "bar";
    }
}