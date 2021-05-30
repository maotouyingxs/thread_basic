package com.mao.threadbasic;

/**
 * @author by maotouying
 * @Classname Test01
 * @Description 现在有T1、T2、T3三个线程，你怎样保证T2在T1执行完后执行，T3在T2执行完后执行  
 * @Date 2021/5/30 21:52
 */
public class Test01 {
    public static void main(String[] args) {
        T1 t1 = new T1();
        Thread thread1 = new Thread(t1);
        T2 t2 = new T2(thread1);
        Thread thread2 = new Thread(t2);
        T3 t3 = new T3(thread2);
        Thread thread3 = new Thread(t3);
        thread3.start();
        thread2.start();
        thread1.start();
    }
}

class T1 implements Runnable {
    @Override
    public void run() {
        System.out.println("我是T1线程");
    }
}

class T2 implements Runnable {
    private Thread t1;

    public T2() {
    }

    public T2(Thread t1) {
        this.t1 = t1;
    }

    @Override
    public void run() {
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("我是T2线程");
    }
}

class T3 implements Runnable {
    private Thread t1;

    public T3() {
    }

    public T3(Thread t1) {
        this.t1 = t1;
    }

    @Override
    public void run() {
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("我是T3线程");
    }
}