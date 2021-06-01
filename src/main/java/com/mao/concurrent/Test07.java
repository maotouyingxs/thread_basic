package com.mao.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author by maotouying
 * @Classname Test07
 * @Description TODO
 * @Date 2021/6/1 7:37
 */
public class Test07 {
    public static void main(String[] args) {
        // 单线程
        ExecutorService executorService = Executors.newSingleThreadExecutor();
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
