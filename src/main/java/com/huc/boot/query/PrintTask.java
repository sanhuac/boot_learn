package com.huc.boot.query;

import com.huc.boot.util.TimeUtil;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/**
 * @Auther: 胡丛
 * @Date: 2018/8/3 12:47
 * @Description: 定时任务
 */
@Component
public class PrintTask {

    /**
     *@描述 串行定时器 每10秒执行一次
     *@参数
     *@返回值  
     *@创建人  胡丛
     *@创建时间  2018/8/3
     *@修改人和其它信息
     */
    //@Scheduled(cron = "0/2 * * * * ? ")
    public void cron()throws Exception{
        System.out.println("start push data scheduled!");
        Thread current = Thread.currentThread();
        System.out.println("定时任务1:"+current.getName());
        System.out.println("执行测试时间："+ TimeUtil.getNormalTime(System.currentTimeMillis()));
        System.out.println("end push data scheduled!");
    }


}
