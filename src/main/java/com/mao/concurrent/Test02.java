package com.mao.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author by maotouying
 * @Classname Test02
 * @Description 阻塞式队列,有界
 * @Date 2021/5/31 22:40
 */
public class Test02 {
    public static void main(String[] args) throws InterruptedException {
        // 存队列的时候，如果满了，就会等待，取队列的时候，如果取不到，也会等待
        // 阻塞式队列，最多支持3个队列总数
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        // 添加非阻塞式队列
        blockingQueue.offer("张三");
        // 添加阻塞式队列
        blockingQueue.offer("李四", 3, TimeUnit.SECONDS);
        blockingQueue.offer("王五");
        blockingQueue.offer("啊猫", 3, TimeUnit.SECONDS);
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll(3,TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(3,TimeUnit.SECONDS));
    }
}
