package com.cedar.concurrency.art;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @author zhangnan
 * @date 2021/1/21 17:09
 */
public class MultiThread {

    public static void main(String[] args) {


        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);

        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println(threadInfo.getThreadId() + "   " + threadInfo.getThreadName());
        }
    }
}
