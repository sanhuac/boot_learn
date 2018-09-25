package com.huc.boot.rabbit;


import com.huc.boot.BootApplication;
import com.huc.boot.bean.User;
import com.huc.boot.util.rabbit.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * @Auther: 胡丛
 * @Date: 2018/8/8 11:29
 * @Description: rabbitmq测试
 */

@RunWith(value=SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BootApplication.class)
public class RabbitTests {

    @Autowired
    private Sender sender;

    /**
     *@描述 发送一个对象单元测试
     *@参数
     *@返回值  
     *@创建人  胡丛
     *@创建时间  2018/8/8
     *@修改人和其它信息
     */
    @Test
    public void sendTest() throws Exception {
            User user = new User();
            user.setAge(12);
            user.setId(1);
            user.setUsername("胡丛");
            user.setCtm(new Date());
            sender.send(user);
            Thread.sleep(1000);

    }


}
