package com.mao.threadpool;

/**
 * @author by maotouying
 * @Classname Data
 * @Description 公共数据接口
 * @Date 2021/6/1 22:46
 */
public abstract interface Data {
    /**
     * 方法的作用 返回线程的执行结果
     * @return 线程的执行结果
     */
    public abstract String getRequest();
}
