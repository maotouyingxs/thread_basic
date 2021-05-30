package com.mao.threadbasic;

/**
 * @author by maotouying
 * @Classname Thread05
 * @Description 守护线程 t1.setDaemon(true);
 * @Date 2021/5/30 20:32
 */
public class Thread05 {
    private static final int COUNT = 10;
    public static void main(String[] args) throws InterruptedException {
        System.out.println("主线程开始执行...");
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("我是子线程（用户线程）");
                }
            }
        });
        // 标识当前方法为守护线程
        t1.setDaemon(true);
        t1.start();
        for (int i = 0; i < 10; i++) {
            Thread.sleep(300);
            System.out.println("main:i:" + i);
        }
        System.out.println("主线程执行完毕...");
    }
}
