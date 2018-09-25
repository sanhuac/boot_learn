package com.huc.boot.redis;

/**
 * @Auther: 胡丛
 * @Date: 2018/8/3 14:19
 * @Description:
 */
public class ThreadA extends Thread {
    private Service service;

    public ThreadA(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.seckill();
    }
}
