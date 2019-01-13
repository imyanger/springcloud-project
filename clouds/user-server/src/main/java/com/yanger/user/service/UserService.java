package com.yanger.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yanger.user.dao.UserDao;
import com.yanger.user.po.User;
import com.yanger.user.vo.UserVo;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	/**
	 * 插入用户
	 * @author YangHao  
	 * @time 2019年1月13日-下午4:22:55
	 * @param userVo
	 */
	public void insertUser(UserVo userVo) throws Exception{
		User user = new User();
		user.setUserCode(userVo.getUserCode());
		user.setUserName(userVo.getUserName());
		user.setPassword(userVo.getPassword());
		userDao.insert(user);
	}
	
	/**
	 * 根据主键删除用户
	 * @author YangHao  
	 * @time 2019年1月13日-下午4:24:11
	 * @param id
	 */
	public void deleteUser(Integer id) throws Exception {
		userDao.delete(id);
	}
	
	/**
	 * 更改用户信息
	 * @author YangHao  
	 * @time 2019年1月13日-下午4:24:42
	 * @param id
	 */
	public void uptateUser(UserVo userVo) throws Exception {
		User user = new User();
		user.setId(userVo.getId());
		user.setUserCode(userVo.getUserCode());
		user.setUserName(userVo.getUserName());
		user.setPassword(userVo.getPassword());
		userDao.update(user);
	}
	
	/**
	 * 根据用户名和密码查找用户
	 * @author YangHao  
	 * @time 2019年1月13日-下午4:28:39
	 * @param userCode
	 * @param password
	 * @return
	 */
	public User findUser(String userCode, String password) throws Exception {
		return userDao.find(userCode, password);
	}
	
}
