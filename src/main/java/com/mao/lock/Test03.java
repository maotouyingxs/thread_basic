package com.mao.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;

/**
 * @author by maotouying
 * @Classname Test03
 * @Description 读写锁(模拟JVM内置缓存)
 * @Date 2021/6/2 21:10
 */
public class Test03 {
    private volatile Map<String, String> caChe = new HashMap<>(10);
    // 读写锁
    private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    // 写入锁
    private WriteLock writeLock = reentrantReadWriteLock.writeLock();
    // 读取锁
    private ReadLock readLock = reentrantReadWriteLock.readLock();

    /**
     * 写入元素
     */
    public void put(String key, String value) {
        try {
            writeLock.lock();
            System.out.println("写入put方法 key:" + key + ",value:" + value + "开始");
            Thread.sleep(100);
            caChe.put(key, value);
            System.out.println("写入put方法 key:" + key + ",value:" + value + "结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            writeLock.unlock();
        }
    }

    /**
     * 读取元素
     */
    public String get(String key) {
        try {
            readLock.lock();
            System.out.println("读取get方法 key:" + key + "开始");
            Thread.sleep(100);
            String value = caChe.get(key);
            System.out.println("读取get方法 key:" + key + "结束");
            return value;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) {

        Test03 test03 = new Test03();
        // 写线程
        Thread write = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    test03.put("i", i + "");
                }
            }
        });
        // 读线程
        Thread read = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    test03.get(i + "");
                }
            }
        });
        write.start();
        read.start();
    }
}
