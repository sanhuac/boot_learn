package com.huc.boot.redis;

/**
 * @Auther: 胡丛
 * @Date: 2018/8/3 14:20
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        Service service = new Service();
        for (int i = 0; i < 50; i++) {
            ThreadA threadA = new ThreadA(service);
            threadA.start();
        }


    }
}