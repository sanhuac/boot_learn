package com.huc.boot.test;

import com.huc.boot.config.Upload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * @Auther: 胡丛
 * @Date: 2018/8/13 14:28
 * @Description:
 */
public class PathTest {

    @Value("${web.upload-path}")
    private static String path;

    public static void main(String[] args) {
        System.out.println("图片路径");
        System.out.println(path);
    }
}
