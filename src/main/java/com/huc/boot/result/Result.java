package com.huc.boot.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/***
 *  @author lizhun
 *	control层和service层交互bean类
 */
@ApiModel(value="固定返回结果", description="固定返回结果")
public class Result implements  java.io.Serializable {

	/**
	 * 返回码
	 */
	@ApiModelProperty(value = "返回码", name = "mark", example = "0")
	public String mark = "-1";

	/**
	 * 提示语
	 */
	@ApiModelProperty(value = "提示语", name = "tip", example = "成功")
	public String tip = "json数据错误";


	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}


}