package com.huc.boot.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: 胡丛
 * @Date: 2018/8/3 11:47
 * @Description: 时间工具类
 */
public class TimeUtil {


    /**
     *@描述 时间转化 yyyy-MM-dd HH:mm:ss
     *@参数  
     *@返回值  
     *@创建人  胡丛
     *@创建时间  2018/8/3
     *@修改人和其它信息
     */
    public static String getNormalTime(long value) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
        String time = format.format(new Date(value)) ;
        return time;
    }
}
