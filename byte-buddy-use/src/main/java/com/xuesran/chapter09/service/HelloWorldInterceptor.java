package com.xuesran.chapter09.service;

public class HelloWorldInterceptor implements Interceptor {
    @Override
    public String doSomethingElse() {
        return "Hello World!";
    }
}
