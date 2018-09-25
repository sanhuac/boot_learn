package com.huc.boot.dao;

import com.huc.boot.bean.DriveTopicEntry;
import com.huc.boot.bean.DriveTopicType;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @Auther: 胡丛
 * @Date: 2018/8/14 14:26
 * @Description: 驾考题目所对应题型
 */
@Mapper
public interface DriveTopicEntryMapper {

    /**
     *@描述 查询所有题目类型
     *@参数
     *@返回值  list
     *@创建人  胡丛
     *@创建时间  2018/8/14
     *@修改人和其它信息
     */
    @Select("select id,name,time,type from drive_topic_type where type = #{type} ")
    @Results({
            @Result(property = "topic_type_id", column = "id")
    })
    List<DriveTopicType> topicTypes(Integer type);
    
    /**
     *@描述 查询题目对应的题型
     *@参数
     *@返回值  list
     *@创建人  胡丛
     *@创建时间  2018/8/14
     *@修改人和其它信息
     */
    @Select("select id,type,subject_id,type_id from drive_topic_one_mapping")
    @Results({
            @Result(property = "entry_id", column = "id")
    })
    List<DriveTopicEntry> entryTypes();

    
    /**
     *@描述 根据题目id查找类型
     *@参数 title_id 题目id
     *@返回值  
     *@创建人  胡丛
     *@创建时间  2018/8/14
     *@修改人和其它信息
     */
    @Select("select id,type,subject_id,type_id from drive_topic_one_mapping where subject_id = #{title_id}")
    @Results({
            @Result(property = "entry_id", column = "id")
    })
    List<DriveTopicEntry> entryTypeBytitleId(Integer title_id);

    /**
     *@描述 根绝类型id查找映射关系
     *@参数 type_id类型id
     *@返回值  
     *@创建人  胡丛
     *@创建时间  2018/8/14
     *@修改人和其它信息
     */
    @Select("select id,type,subject_id,type_id from drive_topic_one_mapping where type_id = #{type_id}")
    @Results({
            @Result(property = "entry_id", column = "id")
    })
    List<DriveTopicEntry> entryTypeByTypeId(Integer type_id);



    /**
     *@描述 根据type和type_id查询类型名称
     *@参数 type type_id
     *@返回值  String
     *@创建人  胡丛
     *@创建时间  2018/8/14
     *@修改人和其它信息
     */
    @Select("select name from drive_topic_type where id = #{type_id} and type = #{type}")
    String typeNameBytypeIdandtype(@Param("type")Integer type,@Param("type_id")Integer type_id);
}
