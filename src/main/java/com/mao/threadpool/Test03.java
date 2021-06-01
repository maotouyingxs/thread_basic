package com.mao.threadpool;

/**
 * @author by maotouying
 * @Classname Test03
 * @Description FUTURE模式
 * @Date 2021/6/1 22:45
 */
public class Test03 {
    public static void main(String[] args) {
        FutureCline futureCline = new FutureCline();
        Data request = futureCline.request("1234");
        System.out.println("数据发送成功");
        System.out.println("主线程执行其他任务");
        String result = request.getRequest();
        System.out.println("主线程获取result:" + result);
    }
}
