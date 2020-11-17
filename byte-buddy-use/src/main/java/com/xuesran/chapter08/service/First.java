package com.xuesran.chapter08.service;

public interface First {
    default String qux(){
        return "foo";
    }
}
