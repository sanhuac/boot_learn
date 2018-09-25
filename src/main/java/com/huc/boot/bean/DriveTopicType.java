package com.huc.boot.bean;

import java.io.Serializable;

/**
 * @Auther: 胡丛
 * @Date: 2018/8/14 14:33
 * @Description: 科目一、科目四题目归属  类型
 */
public class DriveTopicType implements Serializable{


    /**
     * 主键
     */
    private Integer topic_type_id;

    /**
     * 科目一、科目四题目类型名称
     */
    private String name;

    /**
     * 创建时间
     */
    private Integer time;

    /**
     * 题目归属类型  1章节练习 2 易错题 3争议题 4专项练习集合菜单  0其他
     */
    private Integer type;



    public Integer getTopic_type_id() {
        return topic_type_id;
    }

    public void setTopic_type_id(Integer topic_type_id) {
        this.topic_type_id = topic_type_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }


}
