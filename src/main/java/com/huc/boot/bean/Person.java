package com.huc.boot.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: 胡丛
 * @Date: 2018/8/9 10:35
 * @Description:
 */
@Data
public class Person implements Serializable{

    private Integer id;

    private String name;

    private String description;
}
