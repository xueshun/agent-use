package com.xuesran.chapter11.instrument;

import net.bytebuddy.dynamic.scaffold.InstrumentedType;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;

public enum SumImplementation implements Implementation {
    INSTANCE;

    @Override
    public ByteCodeAppender appender(Target implementationTarget) {
        return SumMethod.INSTANCE;
    }

    @Override
    public InstrumentedType prepare(InstrumentedType instrumentedType) {
        return instrumentedType;
    }
}
