package com.mao.lock;

/**
 * @author by maotouying
 * @Classname Test04
 * @Description TODO
 * @Date 2021/6/2 23:23
 */
public class Test04 implements Runnable {
    private int count = 1;

    @Override
    public void run() {
        while (true) {
            if (count >= 170) {
                break;
            }
            Integer count = getCount();
            System.out.println(count);
        }
    }

    public synchronized Integer getCount() {
        try {
            Thread.sleep(50);
            return count++;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        Test04 test04 = new Test04();
        Thread t1 = new Thread(test04);
        Thread t2 = new Thread(test04);
        t1.start();
        t2.start();
    }
}
