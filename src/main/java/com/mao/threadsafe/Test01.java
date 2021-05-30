package com.mao.threadsafe;


/**
 * @author by maotouying
 * @Classname Test01
 * @Description 多线程安全问题
 * @Date 2021/5/30 22:32
 */
public class Test01 {
    public static void main(String[] args) {
        ThreadDemo01 threadDemo01 = new ThreadDemo01();
        Thread t1 = new Thread(threadDemo01, "窗口1");
        Thread t2 = new Thread(threadDemo01, "窗口2");
        t1.start();
        t2.start();
    }
}

class ThreadDemo01 implements Runnable {

    private int count = 100;

    @Override
    public void run() {
        while (count > 0) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sale();
        }
    }

    public synchronized void sale() {
        if (count > 0) {
            System.out.println(Thread.currentThread().getName() + "，出售第" + (100 - count + 1) + "张票");
            count--;
        }
    }
}
