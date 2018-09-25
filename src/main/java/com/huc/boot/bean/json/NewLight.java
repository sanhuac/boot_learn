package com.huc.boot.bean.json;

import lombok.Data;

import java.util.List;

/**
 * @Auther: 胡丛
 * @Date: 2018/8/18 15:12
 * @Description: 新规灯光
 */
@Data
public class NewLight {

   private String name;

   private List<LightVo> namelist;//灯光明分组
}
