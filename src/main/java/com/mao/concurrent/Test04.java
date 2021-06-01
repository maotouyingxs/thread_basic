package com.mao.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author by maotouying
 * @Classname Test04
 * @Description 线程池
 * @Date 2021/6/1 7:19
 */
public class Test04 {
    public static void main(String[] args) {
        // 可缓存的线程池、无线大小
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int temp = i;
            // 可执行线程
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "," + temp);
                }
            });

        }
    }
}
