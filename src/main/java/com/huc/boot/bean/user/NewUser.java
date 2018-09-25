package com.huc.boot.bean.user;

import lombok.Data;

/**
 * @Auther: 胡丛
 * @Date: 2018/8/20 17:05
 * @Description: 新用户
 */
@Data
public class NewUser {

    private Integer user_id;

    private String login_mobile;

    private String realname;

    private String password;

    private String id_card;

    private Integer create_time;

    private String date_time;


}
