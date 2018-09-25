
package com.huc.boot.web;


import com.huc.boot.service.MongodbService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: 胡丛
 * @Date: 2018/9/12 14:31
 * @Description:
 */

@RestController
@RequestMapping("/mongo")
@Slf4j
public class MongoController {

    @Autowired
    private MongodbService service;


    /**
     * 根据主键查询
     * @param id
     * @return
     */

    @RequestMapping(value = "getUser",method = RequestMethod.GET)
    public String get(Integer id) {
        log.info("查询mongodb数据:"+id);
        String grabInfo = service.findYoudunCarrierByuserId(id);
        return grabInfo;
    }

}

