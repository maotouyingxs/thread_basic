package com.mao.threadpool;

import java.util.concurrent.*;

/**
 * @author by maotouying
 * @Classname Test01
 * @Description TODO
 * @Date 2021/6/1 21:34
 */
public class Test01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> submit = executorService.submit(new TaskFeature());
        System.out.println("1.主线程开始执行");
        // 获取执行结果
        String result = submit.get();
        System.out.println("2.result:" + result);
        // FUTURE 模式
    }
}

class TaskFeature implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("3.正在执行任务，需要等待5秒钟时间，执行任务开始");
        Thread.sleep(5000);
        System.out.println("4.正在执行任务，需要等待5秒钟时间，执行任务结束");
        return "啊猫";
    }
}
