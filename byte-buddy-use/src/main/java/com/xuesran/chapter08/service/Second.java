package com.xuesran.chapter08.service;

public interface Second {
    default String qux(){
        return "bar";
    }
}
