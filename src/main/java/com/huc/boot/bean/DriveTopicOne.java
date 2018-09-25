package com.huc.boot.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * 科目一驾考题
 * @author HC
 *
 */
@Data
public class DriveTopicOne implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2834110271422391914L;
	
	/**
	 * 题编号
	 */
	private Integer id;
	
	/**
	 * 题目类型[0:单选题 1:多选题 2:判断题]
	 */
	private Integer titleType;
	
	/**
	 * 问题内容
	 */
	private String question;
	
	/**
	 * 答案选项
	 */
	private String answerSelect;
	
	/**
	 * 答案
	 */
	private String answer;
	
	/**
	 * 考题详解内容
	 */
	private String examinationPaper;
	
	/**
	 * 题目图片
	 */
	private String image;
	
	/**
	 * 考题详解图片
	 */
	private String examinationImage;
	
	/**
	 * 详解视频链接
	 */
	private String examinationUrl;
	
	/**
	 * 专题所属类型
	 */
	private String specialTitle;

	/**
	 * 章节类型
	 */
	private String chapter_type;

	/**
	 * 易错题,争议题
	 */
	private String wrong_type;




	
	

}
