package com.yanger.user.vo;

import java.io.Serializable;

import lombok.Data;

@Data // lombok插件，@Data注解会在编译文件中生成getter和setter及toString等方法
public class UserVo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// 主键id
	private Integer id;
	
	// 用户名代码
	private String userCode;
	
	// 用户名
	private String userName;
	
	// 密码
	private String password;
	
	//喜爱的书籍id
	private String likes;

}
