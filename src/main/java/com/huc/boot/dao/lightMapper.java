package com.huc.boot.dao;


import com.huc.boot.bean.json.LightDetail;
import com.huc.boot.bean.json.LightType;
import com.huc.boot.bean.json.LightVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Auther: 胡丛
 * @Date: 2018/8/18 12:58
 * @Description: 灯光接口
 */
@Mapper
public interface lightMapper {

    //分组
    @Select("SELECT type from light_type GROUP BY type")
    List<Integer> groub();

    //名字分组
    @Select("SELECT title from light_type  WHERE type = #{type} GROUP BY title;")
    List<String> groubNmae(Integer type);

    //新灯光
    @Select("SELECT question,answer,detail from light_detail WHERE light_type_id = 0 and  light_id = (select id from light_type where type = 0 and title = #{name})")
    List<LightVo> listlight0(String name);

    //操作灯光
    @Select("SELECT question,answer,detail from light_detail WHERE light_type_id = 1 and  light_id = (select id from light_type where type = 1 and title = #{name})")
    List<LightVo> listlight1(String name);


}
