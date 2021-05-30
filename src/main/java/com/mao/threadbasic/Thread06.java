package com.mao.threadbasic;

/**
 * @author by maotouying
 * @Classname Thread06
 * @Description 优先级join
 * @Date 2021/5/30 21:45
 */
public class Thread06 {
    public static void main(String[] args) {
        ThreadDemo06 threadDemo06 = new ThreadDemo06();
        Thread t1 = new Thread(threadDemo06);
        t1.start();

        // 先让子线程执行完毕
        try {
            t1.join(); //主线程把执行权让给t1
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 30; i++) {
            System.out.println("主线程,i:" + i);
        }

    }
}


class ThreadDemo06 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            System.out.println("子线程,i:" + i);
        }
    }
}


