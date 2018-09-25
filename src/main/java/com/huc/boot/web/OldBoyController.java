package com.huc.boot.web;

import com.huc.boot.annotation.OldBoy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: 胡丛
 * @Date: 2018/8/3 15:19
 * @Description:
 */
@RestController
public class OldBoyController {

    @OldBoy
    @RequestMapping("/oldboy")
    public void getLog(){
        System.out.println("oldboy is coming");
    }
}
