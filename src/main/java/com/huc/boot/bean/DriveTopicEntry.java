package com.huc.boot.bean;

import java.io.Serializable;

/**
 * @Auther: 胡丛
 * @Date: 2018/8/14 14:28
 * @Description: 题目归属专题类型
 */
public class DriveTopicEntry implements Serializable{

    /**
     * 主键
     */
    private  Integer entry_id;

    /**
     * 题目类型 1章节练习 2 易错题 3争议题 4专项练习集合菜单
     */
    private Integer type;

    /**
     * 题目id
     */
    private Integer subject_id;

    /**
     * 题目类型id
     */
    private Integer type_id;

    public Integer getEntry_id() {
        return entry_id;
    }

    public void setEntry_id(Integer entry_id) {
        this.entry_id = entry_id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(Integer subject_id) {
        this.subject_id = subject_id;
    }

    public Integer getType_id() {
        return type_id;
    }

    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }

    @Override
    public String toString() {
        return "DriveTopicEntry{" +
                "entry_id=" + entry_id +
                ", type=" + type +
                ", subject_id=" + subject_id +
                ", type_id=" + type_id +
                '}';
    }
}
