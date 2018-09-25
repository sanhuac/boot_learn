package com.huc.boot.test;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * @Auther: 胡丛
 * @Date: 2018/9/11 16:21
 * @Description:
 */
public class Accuracy {

    public static String accuracy(double num, double total, int scale){
        DecimalFormat df = (DecimalFormat) NumberFormat.getInstance();
        //可以设置精确几位小数
        df.setMaximumFractionDigits(scale);
        //模式 例如四舍五入
        df.setRoundingMode(RoundingMode.HALF_UP);
        double accuracy_num = num / total * 100;
        return df.format(accuracy_num)+"%";
    }

    public static void main(String[] args) {
        int num = 1;
        int total = 6;
        int scale = 2;
        String result = accuracy(num, total, scale);
        String substring = result.substring(0,result.length()-1);
        System.out.println(result);
        System.out.println(Double.parseDouble(substring));

    }
}
