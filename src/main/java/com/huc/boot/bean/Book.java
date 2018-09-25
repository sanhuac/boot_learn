package com.huc.boot.bean;

import lombok.Data;

/**
 * @Auther: 胡丛
 * @Date: 2018/8/3 17:11
 * @Description: Lombok编程风格
 */
@Data
public class Book {

    /**
     * id
     */

    private Long id;

    /**
     * 名字
     */
    private String name;

    /**
     * 价格
     */
    private String price;


}
