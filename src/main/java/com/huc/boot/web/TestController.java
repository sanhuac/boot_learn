package com.huc.boot.web;

import com.huc.boot.bean.DriveTopicOne;
import com.huc.boot.config.MyWebConfig;
import com.huc.boot.service.ConfigService;
import com.huc.boot.service.TitleService;
import com.huc.boot.service.json.LightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: 胡丛
 * @Date: 2018/8/3 15:38
 * @Description:
 */
@RestController
public class TestController {

    public static final Integer SUBJECT_ONE = 1;//所有题目类型

    public static final Integer SUBJECT_FOUR = 4;//章节类型

    @Autowired
    private ConfigService configService;

    @Autowired
    private TitleService titleService;

    @Autowired
    private LightService lightService;


    @PostMapping("properties")
    public String getProperties(){

        return configService.getProperties();
    }

    @GetMapping("getTitles")
    public Map<String,Object> content(){
        Map<String,Object> map = new LinkedHashMap<>();
        map.put("title_list",titleService.list());//所有题目 `
        map.put("topic_special_type",titleService.topicTypes(SUBJECT_FOUR));//所有题目类型
        map.put("topic_chaper_type",titleService.topicTypes(SUBJECT_ONE));//章节类型
        return map;
    }
    @GetMapping("getJson")
    public Map<String,Object> json(){
        Map<String, Object> map = lightService.map();
        return map;
    }


}
