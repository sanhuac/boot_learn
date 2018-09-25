package com.huc.boot.service;

import com.huc.boot.config.MyWebConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: 胡丛
 * @Date: 2018/8/13 15:17
 * @Description:
 */
@Service
public class ConfigService {

    @Autowired
    private MyWebConfig config;


    public String getProperties(){

        return "name:"+config.getName()+
                "version:"+config.getVersion()+
                "title:"+config.getTitle()+
                "author:"+config.getAuthor()+
                "image_path:"+config.getNick_path();
    }
}
