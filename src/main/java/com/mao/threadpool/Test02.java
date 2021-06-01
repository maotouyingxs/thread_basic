package com.mao.threadpool;

/**
 * @author by maotouying
 * @Classname Test02
 * @Description TODO
 * @Date 2021/6/1 22:33
 */
public class Test02 extends Thread{
    // 执行下载请求（大概需要10分钟）
    @Override
    public void run() {
    //    下载请求
    //    如果我想获取 run 方法执行结果，必须要执行完毕才能获取到结果，整个程序都是阻塞的。
    }

    public static void main(String[] args) {
        Test02 test02 = new Test02();
        test02.start();
    //    主线程如何知道子线程执行完毕
    //    主线程获取子线程执行结果
    }
}
