package com.huc.boot.bean.json;


import lombok.Data;

/**
 * @Auther: 胡丛
 * @Date: 2018/8/18 12:47
 * @Description: 灯光类型
 */
@Data
public class LightType {

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 类型[0:新规灯光  1:灯光操作]
     */
    private Integer type;

    /**
     * 标题
     */
    private String title;
}
