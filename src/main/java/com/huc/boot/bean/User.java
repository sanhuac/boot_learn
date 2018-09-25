package com.huc.boot.bean;

import lombok.Data;
import sun.plugin2.message.Serializer;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: 胡丛
 * @Date: 2018/8/6 09:49
 * @Description:
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = -836527296314113912L;

    private int id;

    private String username;

    private int age;

    private Date ctm;


}
