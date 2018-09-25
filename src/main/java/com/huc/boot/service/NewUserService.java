package com.huc.boot.service;

import com.huc.boot.bean.user.NewUser;
import com.huc.boot.dao.NewUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: 胡丛
 * @Date: 2018/8/20 17:11
 * @Description:
 */
@Service
public class NewUserService {

    @Autowired
    private NewUserMapper newUserDao;

   public List<NewUser> users(){

        List<NewUser> users = newUserDao.users();
        for(int i=0;i<users.size();i++){
             if(users.get(i).getCreate_time()!=null){
                 System.out.println("不为空--"+users.get(i).getUser_id());
             }else{
                 newUserDao.update(users.get(i).getUser_id());
             }
        }
        return users;
    }
}
