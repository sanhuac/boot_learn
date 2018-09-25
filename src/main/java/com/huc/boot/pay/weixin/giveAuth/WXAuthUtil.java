package com.huc.boot.pay.weixin.giveAuth;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.util.DigestUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @Auther: 胡丛
 * @Date: 2018/8/16 16:15
 * @Description: 公用网络请求工具类
 */
public class WXAuthUtil {

    public static final String APPID="wx5ff1a2c3c1841668";//
    public static final String APPSECRET ="59bad404dc6710ddce9232a12369b28e";
    //private static final String TOKEN = "immco";
    public static JSONObject doGetJson(String url) throws ClientProtocolException, IOException {
        JSONObject jsonObject =null;
        DefaultHttpClient client = new DefaultHttpClient();
        HttpGet httpGet =new HttpGet(url);
        HttpResponse response =  client.execute(httpGet);
        HttpEntity entity =response.getEntity();
        if(entity!=null)
        {
            //把返回的结果转换为JSON对象
            String result =EntityUtils.toString(entity, "UTF-8");
            jsonObject =JSON.parseObject(result);
        }

        return jsonObject;
    }
}
