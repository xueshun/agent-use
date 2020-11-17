package com.xuesran.chapter07.interceptor;

import java.util.Arrays;
import java.util.List;

public class MemoryDatabase {

    public List<String> load(String info)  {
        System.out.println("memory " + info);
        return Arrays.asList(info + ": foo", info + ": bar");
    }
}
