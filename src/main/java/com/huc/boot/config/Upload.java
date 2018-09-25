package com.huc.boot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Auther: 胡丛
 * @Date: 2018/8/13 15:06
 * @Description: 加载临时文件目录
 */
@Component
public class Upload {

    @Value("${web.upload-path}")
    private static  String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }


}
