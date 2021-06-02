package com.mao.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author by maotouying
 * @Classname Test02
 * @Description ReentrantLock 重入锁
 * @Date 2021/6/2 21:00
 */
public class Test02 extends Thread {
    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        set();
    }

    public void set() {
        try {
            lock.lock();
            System.out.println("set方法");
            get();
        } finally {
            lock.unlock();
        }
    }

    public void get() {
        try {
            lock.lock();
            System.out.println("lock 可以具备可重入性-get方法");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Test02 test02 = new Test02();
        test02.start();
    }
}
