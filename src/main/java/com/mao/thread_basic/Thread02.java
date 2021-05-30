package com.mao.thread_basic;

public class Thread02 {
    public static void main(String[] args) {
        System.out.println("主线程开始");
        // 1.创建线程
        ThreadDemo02 threadDemo02 = new ThreadDemo02();
        Thread t1 = new Thread(threadDemo02);
        // 2.启动线程
        t1.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("主...i:" + i);
        }
    }
}

class ThreadDemo02 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("子...i:" + i);
        }
    }
}
