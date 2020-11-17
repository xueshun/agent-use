package com.xuesran.chapter11.test;

import com.xuesran.chapter11.instrument.SumExample;
import com.xuesran.chapter11.instrument.SumImplementation;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.matcher.ElementMatchers;

import java.io.File;
import java.io.IOException;

public class InstrumentTest {

    public static void main(String[] args) throws IOException {
        new ByteBuddy()
                .subclass(SumExample.class)
                .method(ElementMatchers.named("calculate"))
                .intercept(SumImplementation.INSTANCE)
                .make()
                .saveIn(new File("G://byte-buddy//chapter10//instrument"));
    }
}
