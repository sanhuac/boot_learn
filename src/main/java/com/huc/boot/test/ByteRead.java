package com.huc.boot.test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static com.huc.boot.util.ImageToByte.getImageFromNetByUrl;

/**
 * @Auther: 胡丛
 * @Date: 2018/8/7 14:34
 * @Description:
 */
public class ByteRead {
    public static void main(String[] args) {
        String url = "https://goss.veer.com/creative/vcg/veer/612/veer-138602095.jpg";
        byte[] btImg = getImageFromNetByUrl(url);
        List a = new ArrayList();
        for(int i=0;i<btImg.length;i++){
            a.add(btImg[i]);

        }
        System.out.println(a);
    }
}
