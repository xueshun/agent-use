package com.xuesran.test;

public class InstrumentAgentTest {

    private void fun1() {
        System.out.println("this is fun 1.");
    }

    private void fun2() {
        System.out.println("this is fun 2.");
    }

    public static void main(String[] args) {
        InstrumentAgentTest test = new InstrumentAgentTest();
        test.fun1();
        test.fun2();
    }
}
