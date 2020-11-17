package com.xuesran.chapter10.annotation;

import java.lang.annotation.Annotation;

public class RuntimeDefinitionImpl implements RuntimeDefinition {
    @Override
    public Class<? extends Annotation> annotationType() {
        return RuntimeDefinition.class;
    }
}
