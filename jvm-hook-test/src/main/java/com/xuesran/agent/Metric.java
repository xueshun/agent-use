package com.xuesran.agent;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.util.Arrays;
import java.util.List;

public class Metric {

    private static final long MB = 1048576L;

    public static void printMemoryInfo(){
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heapMemoryUsage = memoryMXBean.getHeapMemoryUsage();


        String info = String.format("\ninit: %s\t max: %s\t used: %s\t committed: %s\t use rate: %s\n",
                heapMemoryUsage.getInit() / MB + "MB",
                heapMemoryUsage.getMax() / MB + "MB",
                heapMemoryUsage.getUsed() / MB + "MB",
                heapMemoryUsage.getCommitted() / MB + "MB",
                heapMemoryUsage.getUsed() * 100 / heapMemoryUsage.getCommitted() + "%"
        );

        System.out.println(info);

        MemoryUsage nonHeapMemoryUsage = memoryMXBean.getNonHeapMemoryUsage();
        info = String.format("init: %s\t max: %s\t used: %s\t committed: %s\t use rate: %s\n",
                nonHeapMemoryUsage.getInit() / MB + "MB",
                nonHeapMemoryUsage.getMax() / MB + "MB",
                nonHeapMemoryUsage.getUsed() / MB + "MB",
                nonHeapMemoryUsage.getCommitted() / MB + "MB",
                nonHeapMemoryUsage.getUsed() * 100 / nonHeapMemoryUsage.getCommitted() + "%"

        );
        System.out.println(info);
    }

    public static void printGCInfo() {
        List<GarbageCollectorMXBean> garbages = ManagementFactory.getGarbageCollectorMXBeans();
        for (GarbageCollectorMXBean garbage : garbages) {
            String info = String.format("name: %s\t count:%s\t took:%s\t pool name:%s",
                    garbage.getName(),
                    garbage.getCollectionCount(),
                    garbage.getCollectionTime(),
                    Arrays.deepToString(garbage.getMemoryPoolNames()));
            System.out.println(info);
        }
    }
}
