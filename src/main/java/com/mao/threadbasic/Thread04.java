package com.mao.threadbasic;

/**
 * @Classname Thread04
 * @Description Thread.currentThread().sleep(1000) 休眠
 * @Date 2021/5/30 19:01
 * @Created by maotouying
 */
public class Thread04 {
    private static final int CURRENT = 10;
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < CURRENT; i++) {
                    try {
                        Thread.currentThread().sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println("i:" + i);
                }
            }
        });
        t1.start();
    }
}
