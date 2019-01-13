package com.yanger.user.dao;

import org.apache.ibatis.annotations.Mapper;

import com.yanger.user.po.User;

@Mapper
public interface UserDao {
	
	/**
	 * 新增用户
	 * @author YangHao  
	 * @time 2019年1月13日-下午3:17:30
	 */
	void insert(User user);
	
	/**
	 * 删除用户
	 * @author YangHao  
	 * @time 2019年1月13日-下午3:18:13
	 */
	void delete(Integer id);
	
	/**
	 * 修改用户
	 * @author YangHao  
	 * @time 2019年1月13日-下午3:18:56
	 */
	void update(User user);
	
	/**
	 * 查询用户
	 * @author YangHao  
	 * @time 2019年1月13日-下午3:19:24
	 * @return
	 */
	User find(String userCode, String password);
	
}
