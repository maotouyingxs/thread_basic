package com.mao.threadbasic;

/**
 * @author maotouying
 * @Classname Thread04
 * @Description 多线程创建方式二：实现 Runnable 接口
 * @Date 2021/5/30 19:01
 */
public class Thread02 {
    private static final int COUNT = 10;

    public static void main(String[] args) {
        System.out.println("主线程开始");
        // 1.创建线程
        ThreadDemo02 threadDemo02 = new ThreadDemo02();
        Thread t1 = new Thread(threadDemo02);
        // 2.启动线程
        t1.start();
        for (int i = 0; i < COUNT; i++) {
            System.out.println("主...i:" + i);
        }
    }
}

class ThreadDemo02 implements Runnable {
    private static final int COUNT = 10;

    @Override
    public void run() {
        for (int i = 0; i < COUNT; i++) {
            System.out.println("子...i:" + i);
        }
    }
}
