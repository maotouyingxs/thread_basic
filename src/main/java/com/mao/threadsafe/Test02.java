package com.mao.threadsafe;

/**
 * @author by maotouying
 * @Classname Test02
 * @Description ThreadLocal
 * @Date 2021/5/31 19:09
 */
public class Test02 extends Thread {
    private int forCount = 3;
    private Res res;

    public Test02(Res res) {
        this.res = res;
    }

    public Test02() {
    }

    @Override
    public void run() {
        for (int i = 0; i < forCount; i++) {
            System.out.println(Thread.currentThread().getName() + "," + res.getNumber());
        }
    }

    public static void main(String[] args) {
        Res res = new Res();
        Test02 t1 = new Test02(res);
        Test02 t2 = new Test02(res);
        t1.start();
        t2.start();
    }
}

class Res {
    public static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public Integer getNumber() {
        int count = threadLocal.get() + 1;
        threadLocal.set(count);
        return count;
    }
}

