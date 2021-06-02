package com.mao.lock;

/**
 * @author by maotouying
 * @Classname Test01
 * @Description synchronized 重入锁
 * @Date 2021/6/2 20:23
 */
public class Test01 extends Thread {
    @Override
    public void run() {
        set();
    }

    public synchronized void set() {
        System.out.println("set方法");
        get();
    }

    public synchronized void get() {
        System.out.println("synchronized 可以具备可重入性-get方法");
    }

    public static void main(String[] args) {
        Test01 test01 = new Test01();
        test01.start();
    }
}
