package com.yanger.user.api;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yanger.common.vo.ApiResponse;
import com.yanger.user.po.User;
import com.yanger.user.service.RibbonService;
import com.yanger.user.service.UserService;
import com.yanger.user.vo.BookVo;
import com.yanger.user.vo.UserVo;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("user")
@Api // swagger文档支持接口，方便接口查看和调用
public class UserApi {
	
	@Autowired
	UserService userService;
	
	@Autowired
	RibbonService ribbonService;
	
	/**
	 * @description 插入用户
	 * @author YangHao  
	 * @time 2019年1月13日-下午5:29:52
	 * @param userVo
	 * @return
	 */
	@PostMapping("insert")
	public ApiResponse<String> insertUser(@RequestBody UserVo userVo) {
		ApiResponse<String> api = new ApiResponse<>();
		try {
			userService.insertUser(userVo);
		} catch (Exception e) {
			api.error("用户插入异常");
			e.printStackTrace();
		}
		return api;
	}

	/**
	 * @description 删除用户
	 * @author YangHao  
	 * @time 2019年1月13日-下午5:30:07
	 * @param userVo
	 * @return
	 */
	@DeleteMapping("delete/{id}")
	public ApiResponse<String> deleteUser(@PathVariable Integer id) {
		ApiResponse<String> api = new ApiResponse<>();
		try {
			userService.deleteUser(id);
		} catch (Exception e) {
			api.error("删除用户异常");
			e.printStackTrace();
		}
		return api;
	}
	
	/**
	 * @description 更新用户
	 * @author YangHao  
	 * @time 2019年1月13日-下午5:32:08
	 * @param userVo
	 * @return
	 */
	@PostMapping("update")
	public ApiResponse<String> uptateUser(UserVo userVo) {
		ApiResponse<String> api = new ApiResponse<>();
		try {
			userService.uptateUser(userVo);
		} catch (Exception e) {
			api.error("更新用户异常");
			e.printStackTrace();
		}
		return api;
	}
	
	/**
	 * @description 根据用户名和密码查找用户
	 * @author YangHao  
	 * @time 2019年1月13日-下午5:32:34
	 * @param userVo
	 * @return
	 */
	@GetMapping("find")
	public ApiResponse<User> findUser(@RequestParam String userCode, @RequestParam String password) {
		ApiResponse<User> api = new ApiResponse<>();
		try {
			User user = userService.findUser(userCode, password);
			api.setData(user);
		} catch (Exception e) {
			api.error("根据用户名和密码查找用户异常");
			e.printStackTrace();
		}
		return api;
	}
	
	/**
	 * @description 根据id查找用户(通过ribbon调用)
	 * @author YangHao  
	 * @time 2019年1月13日-下午5:32:34
	 * @param userVo
	 * @return
	 */
	@GetMapping("/find/ribbon/{id}")
	public ApiResponse<UserVo> findUserRibbon(@PathVariable Integer id) {
		ApiResponse<UserVo> api = new ApiResponse<>();
		try {
			UserVo userVo = new UserVo();
			User user = userService.findUser(id);
			BeanUtils.copyProperties(user, userVo);
			List<BookVo> bookVos = ribbonService.findByIds(user.getLikes());
			bookVos.forEach(bookVo -> log.info("bookService通过ribbon调用服务获取数据：{}", bookVo.toString()));
			userVo.setBooks(bookVos);
			api.setData(userVo);
		} catch (Exception e) {
			api.error("根据id查找用户(通过ribbon调用)异常");
			e.printStackTrace();
		}
		return api;
	}
	
}
