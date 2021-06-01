package com.mao.threadpool;

/**
 * @author by maotouying
 * @Classname Future
 * @Description 当有线程想要获取RealData的时候，程序会被阻塞。等到RealData被注入才会使用getReal()方法。
 * @Date 2021/6/1 22:49
 */
public class FutureData implements Data {
    // 读取结果
    private boolean FLAG = false;
    private RealData readData;

    /**
     * 读取data数据
     */
    public synchronized void setRedData(RealData redData) {
        // 如果 FLAG 为 true 表示获取到数据
        if (FLAG) {
            return;
        }
    //    如果 FLAG 为 false，没有获取到数据，传递 realData 对象
        this.readData = redData;
        FLAG = true;
        notify();
    }

    @Override
    public synchronized String getRequest() {
        while (!FLAG) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return readData.getRequest();
    }
}
