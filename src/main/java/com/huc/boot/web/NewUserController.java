package com.huc.boot.web;

import com.huc.boot.bean.user.NewUser;
import com.huc.boot.service.NewUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: 胡丛
 * @Date: 2018/8/20 17:18
 * @Description:
 */
@RestController
public class NewUserController {

    @Autowired
    private NewUserService newUserService;

    @PostMapping("newUser")
    public List<NewUser> newUser(){

        return  newUserService.users();
    }
}
