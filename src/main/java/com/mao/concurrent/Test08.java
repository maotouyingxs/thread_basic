package com.mao.concurrent;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author by maotouying
 * @Classname Test08
 * @Description TODO
 * @Date 2021/6/1 8:14
 */
public class Test08 {
    public static void main(String[] args) {
        // 目的：保证所有真正的线程都能被实际的用到  核心线程数：实际运行的线程 最大线程数：可以创建多少个线程
        // 核心线程数1，最大创建2个线程 keepAliveTime 线程空闲时间
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(3));
        // 任务1 现在创建线程正在执行
        threadPoolExecutor.execute(new TaskThread("任务1"));
        // 任务2 存放到缓存队列中
        threadPoolExecutor.execute(new TaskThread("任务2"));
        // 任务3 存放到缓存队列中
        threadPoolExecutor.execute(new TaskThread("任务3"));
        // 任务4 存放到缓存队列中
        threadPoolExecutor.execute(new TaskThread("任务4"));
        // 任务5 判断是否超过最大线程数  没有  创建新线程执行
        threadPoolExecutor.execute(new TaskThread("任务5"));
        // 任务6 超过最大线程数  报错
        // threadPoolExecutor.execute(new TaskThread("任务6"));
    }
}

class TaskThread implements Runnable {
    private String threadName;

    public TaskThread(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + threadName);
    }
}
