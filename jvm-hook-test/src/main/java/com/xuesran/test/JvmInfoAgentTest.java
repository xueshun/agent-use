package com.xuesran.test;

import java.util.ArrayList;
import java.util.List;

public class JvmInfoAgentTest {

    public static void main(String[] args) {
        boolean is = true;
        while (is){
            List<Object> list = new ArrayList<Object>();
            list.add("hello world");
        }
    }
}
