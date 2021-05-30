package com.mao.thread_basic;

public class Thread03 {
    public static void main(String[] args) {
        System.out.println("主线程开始了...");

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("子...i:" + i);
                }
            }
        });
        t1.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("主...i:" + i);
        }
        System.out.println("主线程结束了...");
    }
}
