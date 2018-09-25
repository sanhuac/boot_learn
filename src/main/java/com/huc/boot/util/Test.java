package com.huc.boot.util;

import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Random;

/**
 * @Auther: 胡丛
 * @Date: 2018/8/20 19:19
 * @Description:
 */
public class Test {

    final static String decodedText = "PD94bWwgIHZlcnNpb249IjEuMCIgZW5jb2Rpbmc9IkdCSyIgc3RhbmRhbG9uZT0ibm8iID8+PEIyQ1Jlcz48aW50ZXJmYWNlTmFtZT5JQ0JDX1dBUEJfQjJDPC9pbnRlcmZhY2VOYW1lPjxpbnRlcmZhY2VWZXJzaW9uPjEuMC4wLjY8L2ludGVyZmFjZVZlcnNpb24+PG9yZGVySW5mbz48b3JkZXJEYXRlPjIwMTMwNDEwMTMzODQ2PC9vcmRlckRhdGU+PG9yZGVyaWQ+MjAxMzA0MTAxMzM4NDYwPC9vcmRlcmlkPjxhbW91bnQ+NTAwPC9hbW91bnQ+PGluc3RhbGxtZW50VGltZXM+MTwvaW5zdGFsbG1lbnRUaW1lcz48bWVyQWNjdD4wMjAwMDI0MTA5MDMxNTQ4NTY5PC9tZXJBY2N0PjxtZXJJRD4wMjAwRUMyMzMzNTE0OTwvbWVySUQ+PGN1clR5cGU+MDAxPC9jdXJUeXBlPjx2ZXJpZnlKb2luRmxhZz4wPC92ZXJpZnlKb2luRmxhZz48Sm9pbkZsYWc+MDwvSm9pbkZsYWc+PFVzZXJOdW0+PC9Vc2VyTnVtPjwvb3JkZXJJbmZvPjxiYW5rPjxUcmFuU2VyaWFsTm8+MTIzNDU2Nzg5MDwvVHJhblNlcmlhbE5vPjxub3RpZnlEYXRlPjIwMTMwNDEwMTM0MTU0PC9ub3RpZnlEYXRlPjx0cmFuU3RhdD4xPC90cmFuU3RhdD48Y29tbWVudD69u9LXs8m5pqOs0tHH5cvjo6E8L2NvbW1lbnQ+PC9iYW5rPjwvQjJDUmVzPg==";

    private static String CertificatePathDataKey = "F:/certificate/mer_key.key";//私钥绝对路径

    private static String CertificatePathDataCrt = "F:/certificate/mer_cer.cer";//证书绝对路径

    public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException {
        //String enc = Base64Util.encBase64("胡丛");
       /* String dec = Base64Util.desBase64(decodedText);
        Map map = xmlUtil.readStringXmlOut(dec);
        System.out.println("测试数据"+map);*/
        /*StringBuilder str=new StringBuilder();//定义变长字符串
        Random random=new Random();*/
       //随机生成数字，并添加到字符串
      /*  for(int i=0;i<9;i++){
            str.append(random.nextInt(10));
        }*/
        //将字符串转换为数字并输
        //System.out.println(str.toString());
      /*  String number = "123.456";
        String intNumber = number.substring(0,number.indexOf("."));
        System.out.println(intNumber);*/

        String userCrtPath=new File(CertificatePathDataCrt).getAbsolutePath();
        String userKeyPath=new File(CertificatePathDataKey).getAbsolutePath();
        System.out.println(userCrtPath);
        System.out.println(userKeyPath);
        File file1 = ResourceUtils.getFile("classpath:certificate/mer_cer.cer");
        File file2 = ResourceUtils.getFile("classpath:certificate/mer_key.key");
        System.out.println(file1.getPath());
        System.out.println(file2.getPath());


    }
}

