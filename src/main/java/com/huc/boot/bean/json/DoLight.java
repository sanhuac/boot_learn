package com.huc.boot.bean.json;

import lombok.Data;

import java.util.List;

/**
 * @Auther: 胡丛
 * @Date: 2018/8/18 15:18
 * @Description: 灯光操作
 */
@Data
public class DoLight {

    private String name;

    private List<LightVo> namelist;//灯光明分组
}
