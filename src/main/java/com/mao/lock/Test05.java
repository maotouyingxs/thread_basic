package com.mao.lock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author by maotouying
 * @Classname Test05
 * @Description TODO
 * @Date 2021/6/2 23:35
 */
public class Test05 implements Runnable{
    // private int count = 1;
    // 线程安全的i++
    AtomicInteger atomicInteger = new AtomicInteger();
    @Override
    public void run() {
        while (true) {
            Integer count = getCount();
            if (count >= 170) {
                break;
            }
            System.out.println(count);
        }
    }

    public synchronized Integer getCount() {
        try {
            Thread.sleep(50);
            return atomicInteger.incrementAndGet();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {

        Test05 test05 = new Test05();
        Thread t1 = new Thread(test05);
        Thread t2 = new Thread(test05);
        t1.start();
        t2.start();
    }
}
