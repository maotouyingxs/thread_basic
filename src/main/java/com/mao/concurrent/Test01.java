package com.mao.concurrent;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author by maotouying
 * @Classname Test01
 * @Description 非阻塞式队列，无界
 * @Date 2021/5/31 22:31
 */
public class Test01 {
    public static void main(String[] args) {
        // 非阻塞式队列，无界队列
        ConcurrentLinkedQueue<String> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        concurrentLinkedQueue.offer("张三");
        concurrentLinkedQueue.offer("李四");
        concurrentLinkedQueue.offer("王五");
        // 获取队列
        System.out.println(concurrentLinkedQueue.poll());
        // 获取队列个数
        System.out.println(concurrentLinkedQueue.size());
    }
}
