package com.mao.threadbasic;

/**
 * @author maotouying
 * @Classname Thread04
 * @Description 多线程创建方式三：匿名内部类
 * @Date 2021/5/30 19:01
 */
public class Thread03 {

    private static final int COUNT = 10;

    public static void main(String[] args) {
        System.out.println("主线程开始了...");

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < COUNT; i++) {
                    System.out.println("子...i:" + i);
                }
            }
        });
        t1.start();
        for (int i = 0; i < COUNT; i++) {
            System.out.println("主...i:" + i);
        }
        System.out.println("主线程结束了...");
    }
}
