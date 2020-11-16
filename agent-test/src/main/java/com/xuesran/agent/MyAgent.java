package com.xuesran.agent;

import java.lang.instrument.Instrumentation;

/**
 * @author xueshun
 */
public class MyAgent {
    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("this is an agent.");
        System.out.println("args:" + agentArgs + "\n");
    }
}
