package com.huc.boot.pay.weixin.giveAuth;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @Auther: 胡丛
 * @Date: 2018/8/17 09:23
 * @Description:
 */
public class Run {

    public static void main(String[] args) throws UnsupportedEncodingException {

        String backUrl="http://cs.zhouzhoutech.com/weixin/callBack";

        String encode = URLEncoder.encode(backUrl, "UTF-8");
        System.out.println(encode);
    }
}
