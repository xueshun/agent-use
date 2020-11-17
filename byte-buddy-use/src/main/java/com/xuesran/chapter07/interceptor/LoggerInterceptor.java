package com.xuesran.chapter07.interceptor;

import net.bytebuddy.implementation.bind.annotation.SuperCall;

import java.util.List;
import java.util.concurrent.Callable;

public class LoggerInterceptor {

    public static List<String> log(@SuperCall Callable<List<String>> zuper)  {
        System.out.println("Calling database");
        try {
            return zuper.call();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Returned from database");
        }
        return null;
    }
}
