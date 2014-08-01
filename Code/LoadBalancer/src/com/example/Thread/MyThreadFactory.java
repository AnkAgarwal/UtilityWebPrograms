package com.example.Thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class MyThreadFactory implements ThreadFactory {
    private final ThreadGroup group;
    private final AtomicInteger threadNumber = new AtomicInteger(0);
    //private final String namePrefix;

    public MyThreadFactory() {
        SecurityManager s = System.getSecurityManager();
        group = (s != null)? s.getThreadGroup():Thread.currentThread().getThreadGroup();
        //namePrefix = "";
    }

    public Thread newThread(Runnable r) {
        Thread t = new Thread(group, r, threadNumber.getAndIncrement()+"", 0);
        if (t.isDaemon())
            t.setDaemon(false);
        if (t.getPriority() != Thread.NORM_PRIORITY)
            t.setPriority(Thread.NORM_PRIORITY);
        return t;
    }
 }
