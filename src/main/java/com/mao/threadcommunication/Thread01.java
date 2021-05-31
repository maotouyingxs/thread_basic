package com.mao.threadcommunication;

/**
 * @author by maotouying
 * @Classname Thread01
 * @Description 线程间通讯
 * @Date 2021/5/31 20:13
 */
public class Thread01 {
    public static void main(String[] args) {
        Res res = new Res();
        IntThad intThad = new IntThad(res);
        OutThad outThad = new OutThad(res);
        intThad.start();
        outThad.start();
    }
}

class Res {
    /**
     * 姓名
     */
    public String userName;
    /**
     * 性别
     */
    public String userSex;
    /**
     * 为 true 表示：只能读，不能写
     * 为 false 表示：只能写，不能读
     */
    public boolean flag;
}

class IntThad extends Thread {
    private Res res;

    public IntThad(Res res) {
        this.res = res;
    }

    @Override
    public void run() {
        int count = 0;
        while (true) {
            synchronized (res) {
                if (res.flag) {
                    try {
                        res.wait(); // 释放当前锁对象
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (count == 0) {
                    res.userName = "老猫";
                    res.userSex = "男";
                } else {
                    res.userName = "啊猫";
                    res.userSex = "女";
                }
                count = (count + 1) % 2;
                // 标记当前线程为写的状态
                res.flag = true;
                // 唤醒被等待的线程
                res.notify();
            }
        }
    }
}

class OutThad extends Thread {
    private Res res;

    public OutThad(Res res) {
        this.res = res;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (res) {
                if (!res.flag) {
                    try {
                        res.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(res.userName + "---" + res.userSex);
                res.flag = false;
                res.notify();
            }
        }
    }
}