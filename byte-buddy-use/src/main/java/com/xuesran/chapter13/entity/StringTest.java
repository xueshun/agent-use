package com.xuesran.chapter13.entity;

public class StringTest{

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;


    public StringTest(String name) {
        this.name = name;
    }

    public StringTest() {
    }

    @Override
    public String toString() {
        return super.toString() + name;
    }
}