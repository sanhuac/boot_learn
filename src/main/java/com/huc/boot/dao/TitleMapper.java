package com.huc.boot.dao;

import com.huc.boot.bean.DriveTopicOne;
import org.mapstruct.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
 * @Auther: 胡丛
 * @Date: 2018/8/13 16:24
 * @Description:
 */
@Mapper
public interface TitleMapper {

    /**
     * 科目一所有考题
     * @return
     */
    @Select("select * from drive_topic_one where subject_type = #{subject_type}")
    List<DriveTopicOne> selectAll(Integer subject_type);




}
