package com.huc.boot.service.json;

import com.huc.boot.bean.json.DoLight;
import com.huc.boot.bean.json.LightDetail;
import com.huc.boot.bean.json.LightVo;
import com.huc.boot.bean.json.NewLight;
import com.huc.boot.dao.lightMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: 胡丛
 * @Date: 2018/8/18 12:59
 * @Description:
 */
@Service
public class LightService {

    @Autowired
    private lightMapper lightDao;


    /**
     *@描述 返回灯光json数据
     *@参数  
     *@返回值  
     *@创建人  胡丛
     *@创建时间  2018/8/18
     *@修改人和其它信息
     */
    public Map<String,Object> map(){
        Map<String,Object> map = new LinkedHashMap<>();
        List<NewLight> list1 = new ArrayList<NewLight>();
        List<DoLight> list2 = new ArrayList<DoLight>();
        //新灯光
        List<String> groub1 = lightDao.groubNmae(0);
        for(int i=0;i<groub1.size();i++){
            NewLight newLight = new NewLight();
            newLight.setName(groub1.get(i));
            newLight.setNamelist(lightDao.listlight0(groub1.get(i)));
            list1.add(newLight);
        }


        //操作灯光

        List<String> groub2 = lightDao.groubNmae(1);
        for(int i=0;i<groub2.size();i++){
            DoLight doLight = new DoLight();
            doLight.setName(groub2.get(i));
            doLight.setNamelist(lightDao.listlight1(groub2.get(i)));
            list2.add(doLight);
        }
        map.put("new_light",list1);
        map.put("do_light",list2);
        return map;
    }
}
