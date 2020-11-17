package com.xuesran.chapter07.interceptor;

public interface Forwarder<T,S> {
    T to(S target);
}
