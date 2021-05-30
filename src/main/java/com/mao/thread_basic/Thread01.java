package com.mao.thread_basic;

public class Thread01 {
    public static void main(String[] args) {
        System.out.println("主线程开始");
        ThreadDemo01 threadDemo01 = new ThreadDemo01();
        threadDemo01.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("主...i:" + i);
        }
    }
}

class ThreadDemo01 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("子...i:" + i);
        }
    }
}
