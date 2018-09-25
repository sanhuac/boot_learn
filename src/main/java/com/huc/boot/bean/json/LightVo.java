package com.huc.boot.bean.json;

import lombok.Data;

/**
 * @Auther: 胡丛
 * @Date: 2018/8/18 14:07
 * @Description: 返回参数
 */
@Data
public class LightVo {


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


}
