package com.xuesran.chapter12.allotter;

import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
import net.bytebuddy.matcher.ElementMatchers;

public enum ToStringAssigner implements Assigner {
    INSTANCE;

    @Override
    public StackManipulation assign(TypeDescription.Generic source,
                                    TypeDescription.Generic target,
                                    Typing typing) {
        if(!source.isPrimitive() && target.represents(String.class)){
            MethodDescription.InDefinedShape toStringMethod = new TypeDescription.ForLoadedType(Object.class)
                    .getDeclaredMethods()
                    .filter(ElementMatchers.named("toString"))
                    .getOnly();
            //TODO
            return MethodInvocation.invoke(toStringMethod).virtual((TypeDescription) source);
        }else{
            return StackManipulation.Illegal.INSTANCE;
        }
    }
}
