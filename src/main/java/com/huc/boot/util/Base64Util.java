package com.huc.boot.util;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * @Auther: 胡丛
 * @Date: 2018/8/20 18:37
 * @Description:Base64
 */
public class Base64Util {


    final static  Base64.Decoder decoder = Base64.getDecoder();
    final static Base64.Encoder encoder = Base64.getEncoder();


    /**
     *@描述 base64编码
     *@参数  
     *@返回值  
     *@创建人  胡丛
     *@创建时间  2018/8/20
     *@修改人和其它信息
     */
    public static String encBase64(String text) throws UnsupportedEncodingException {
        byte[] textByte = text.getBytes("UTF-8");
        String encodedText = encoder.encodeToString(textByte);
        return  encodedText;
    }

    /**
     *@描述 base64解码GBK
     *@参数  
     *@返回值  
     *@创建人  胡丛
     *@创建时间  2018/8/20
     *@修改人和其它信息
     */
    public static String desBase64(String text) throws UnsupportedEncodingException {
        String decodedText = new String(decoder.decode(text), "GBK");
        return  decodedText;
    }

}
