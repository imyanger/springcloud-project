package com.yanger.user.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.yanger.user.po.User;

@Mapper
public interface UserDao {
	
	/**
	 * @description 新增用户
	 * @author YangHao  
	 * @time 2019年1月13日-下午3:17:30
	 */
	void insert(User user);
	
	/**
	 * @description 删除用户
	 * @author YangHao  
	 * @time 2019年1月13日-下午3:18:13
	 */
	void delete(@Param("id") Integer id);
	
	/**
	 * @description 更改用户信息
	 * @author YangHao  
	 * @time 2019年1月13日-下午3:18:56
	 */
	void update(User user);
	
	/**
	 * @description 查询用户
	 * @author YangHao  
	 * @time 2019年1月13日-下午3:19:24
	 * @return
	 */
	User find(@Param("userCode") String userCode, @Param("password") String password);
	
}
