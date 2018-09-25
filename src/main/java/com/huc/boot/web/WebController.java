package com.huc.boot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: 胡丛
 * @Date: 2018/8/18 16:06
 * @Description:
 */
@Controller
public class WebController {

    @RequestMapping("index")
    public String index(){
        System.out.println("首页");
        return "des";
    }

}
