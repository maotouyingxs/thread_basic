package com.mao.threadsafe;


/**
 * @author by maotouying
 * @Classname Test01
 * @Description 多线程安全问题
 * @Date 2021/5/30 22:32
 */
public class Test01 {
    public static void main(String[] args) throws InterruptedException {
        ThreadDemo01 threadDemo01 = new ThreadDemo01();
        Thread t1 = new Thread(threadDemo01, "窗口1");
        Thread t2 = new Thread(threadDemo01, "窗口2");
        t1.start();
        Thread.sleep(40);
        threadDemo01.flag = false;
        t2.start();
    }
}

class ThreadDemo01 implements Runnable {

    private static int count = 100;
    private Object oj = new Object();
    public boolean flag = true;

    @Override
    public void run() {
        if (flag) {
            while (count > 0) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (this) {
                    if (count > 0) {
                        System.out.println(Thread.currentThread().getName() + "，出售第" + (100 - count + 1) + "张票");
                        count--;
                    }
                }
            }
        } else {
            while (count > 0) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sale();
            }
        }
    }

    /**
     * 同步方法方式
     */
    public synchronized void sale() {
        if (count > 0) {
            System.out.println(Thread.currentThread().getName() + "，出售第" + (100 - count + 1) + "张票");
            count--;
        }
    }

    /**
     * 同步代码块方式
     */
    // public void sale() {
    //     synchronized (this) {
    //         if (count > 0) {
    //             System.out.println(Thread.currentThread().getName() + "，出售第" + (100 - count + 1) + "张票");
    //             count--;
    //         }
    //     }
    // }
    /**
     * 静态同步代码块方式（锁是当前类的字节码文件）
     */
    // public static synchronized  void sale() {
    //     if (count > 0) {
    //         System.out.println(Thread.currentThread().getName() + "，出售第" + (100 - count + 1) + "张票");
    //         count--;
    //     }
    // }
}
