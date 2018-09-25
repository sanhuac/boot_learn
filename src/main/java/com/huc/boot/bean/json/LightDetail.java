package com.huc.boot.bean.json;

import lombok.Data;

/**
 * @Auther: 胡丛
 * @Date: 2018/8/18 12:53
 * @Description: 灯光详情
 */
@Data
public class LightDetail {

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 灯光类型id
     */
    private Integer light_type_id;

    /**
     * 问题
     */
    private String question;

    /**
     * 问题答案
     */
    private String answer;

    /**
     * 问题详解
     */
    private String detail;

    /**
     * 灯光id
     */
    private Integer light_id;


}
