package com.xuesran.chapter12.test;

import com.xuesran.chapter12.allotter.ToStringAssigner;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.implementation.bytecode.assign.primitive.PrimitiveTypeAwareAssigner;
import net.bytebuddy.matcher.ElementMatchers;

import java.io.File;
import java.io.IOException;

/**
 * 创建自定义分配器
 */
public class AllotterTest {

    public static void main(String[] args) throws IOException {
        new ByteBuddy()
                .subclass(Object.class)
                .method(ElementMatchers.named("toString"))
                .intercept(FixedValue.value(42)
                        .withAssigner(new PrimitiveTypeAwareAssigner(ToStringAssigner.INSTANCE), Assigner.Typing.STATIC))
                .make()
                .saveIn(new File("G://byte-buddy//chapter12"));
    }
}
