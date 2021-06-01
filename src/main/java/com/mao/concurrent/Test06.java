package com.mao.concurrent;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author by maotouying
 * @Classname Test06
 * @Description 线程池
 * @Date 2021/6/1 7:33
 */
public class Test06 {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int temp = i;
            // 可执行线程
            scheduledExecutorService.schedule(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "," + temp);
                }
            }, 3, TimeUnit.SECONDS);
        }

    }
}
