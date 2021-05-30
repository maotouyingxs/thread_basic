package com.mao.threadbasic;

/**
 * @author by maotouying
 * @Classname Thread04
 * @Description 多线程创建方式一：继承 Thread 类
 * @Date 2021/5/30 19:01
 */
public class Thread01 {
    private static final int COUNT = 10;

    public static void main(String[] args) {
        System.out.println("主线程开始");
        // 1.创建线程
        ThreadDemo01 threadDemo01 = new ThreadDemo01();
        // 2.启动线程
        threadDemo01.start();
        for (int i = 0; i < COUNT; i++) {
            System.out.println("主...i:" + i);
        }
    }
}

class ThreadDemo01 extends Thread {
    private static final int COUNT = 10;

    @Override
    public void run() {
        for (int i = 0; i < COUNT; i++) {
            System.out.println("子...i:" + i);
        }
    }
}
