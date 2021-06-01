package com.mao.threadpool;

/**
 * @author by maotouying
 * @Classname FutureCline
 * @Description TODO
 * @Date 2021/6/1 23:10
 */
public class FutureCline {
    public Data request(String requestData) {
        FutureData futureData = new FutureData();
        new Thread(new Runnable() {
            @Override
            public void run() {
                RealData realData = new RealData("1234");
                futureData.setRedData(realData);
            }
        }).start();
        return futureData;
    }
}
