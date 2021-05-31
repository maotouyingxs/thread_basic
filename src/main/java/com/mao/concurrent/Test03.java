package com.mao.concurrent;

import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author by maotouying
 * @Classname Test03
 * @Description 生产者与消费者
 * @Date 2021/5/31 22:57
 */
public class Test03 {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>(10);
        ProducerThread producerThread = new ProducerThread(blockingQueue);
        ConsumerThread consumerThread = new ConsumerThread(blockingQueue);

        Thread p1 = new Thread(producerThread);
        Thread c1 = new Thread(consumerThread);
        p1.start();
        c1.start();
        try {
            Thread.sleep(1000 * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        producerThread.stop();
    }
}

/**
 * 生产者 添加队列
 */
class ProducerThread implements Runnable {
    public BlockingQueue<String> blockingQueue;
    private volatile boolean FLAG = true;
    AtomicInteger atomicInteger = new AtomicInteger();

    public ProducerThread(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        System.out.println("生产者已经启动...");
        try {
            while (FLAG) {
                String data = atomicInteger.incrementAndGet() + "";
                boolean offer = blockingQueue.offer(data, 2, TimeUnit.SECONDS);
                if (offer) {
                    System.out.println("生产者存入队列成功! data:" + data);
                } else {
                    System.out.println("生产者存入队列失败! data:" + data);
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("生产者已经结束...");
        }
    }

    public void stop() {
        this.FLAG = false;
    }
}

/**
 * 消费者 获取队列
 */
class ConsumerThread implements Runnable {
    public BlockingQueue<String> blockingQueue;
    private volatile boolean FLAG = true;

    public ConsumerThread(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        System.out.println("消费者已经启动...");
        try {
            while (FLAG) {
                String data = blockingQueue.poll(2, TimeUnit.SECONDS);
                if (StringUtils.isEmpty(data)) {
                    System.out.println("超过2秒时间，没有获取到队列信息");
                    FLAG = false;
                    return;
                }
                System.out.println("消费者获取到data:" + data);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("消费者已经结束...");
        }
    }
}