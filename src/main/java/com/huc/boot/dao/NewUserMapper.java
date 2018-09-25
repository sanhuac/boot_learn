package com.huc.boot.dao;

import com.huc.boot.bean.user.NewUser;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Auther: 胡丛
 * @Date: 2018/8/20 17:04
 * @Description: 新用户数据处理
 */
public interface NewUserMapper {


    /**
     *@描述 查询所有用户
     *@参数  
     *@返回值  
     *@创建人  胡丛
     *@创建时间  2018/8/20
     *@修改人和其它信息
     */
    @Select("select * from new_user")
    List<NewUser> users();

    /**
     *@描述 更新用户信息
     *@参数
     *@返回值  
     *@创建人  胡丛
     *@创建时间  2018/8/20
     *@修改人和其它信息
     */
    @Update("update new_user set create_time = 0 where user_id = #{user_id}")
    int update(Integer user_id);
}
