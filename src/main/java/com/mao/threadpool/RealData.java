package com.mao.threadpool;

/**
 * @author by maotouying
 * @Classname ReadData
 * @Description 获取真实数据
 * @Date 2021/6/1 22:57
 */
public class RealData implements Data{

    private String result;

    public RealData(String requestData) {
        System.out.println("正在使用data进行网络请求,data:" + requestData + "开始...");
        try {
            // 业务操作耗时代码
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("操作执行完毕...获取结果");
        // 业务返回结果
        result = "啊猫";
    }

    @Override
    public String getRequest() {
        return result;
    }
}
