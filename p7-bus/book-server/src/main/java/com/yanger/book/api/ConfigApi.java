package com.yanger.book.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yanger.common.vo.ApiResponse;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@Slf4j //引入日志变量log
@RestController
@RequestMapping("config")
@Api // swagger文档支持接口，方便接口查看和调
@RefreshScope // 支持动态刷新注解，刷新方式：http://localhost:10830/actuator/bus-refresh，简单请求调用可以使用火狐插件rested
public class ConfigApi {
	
	@Value("${redis.ip}")
	private String ip;
	
	/**
	 * @description 获取config中心数据
	 * @author YangHao  
	 * @time 2019年1月20日-下午7:15:01
	 * @return
	 */
	@GetMapping("redis")
	public ApiResponse<String> redis() {
		ApiResponse<String> api = new ApiResponse<>();
		try {
			log.info("redis获取器ip为{}", ip);
			api.setData("redis获取器ip为" + ip);
		} catch (Exception e) {
			api.error("获取config中心数据异常");
			e.printStackTrace();
		}
		return api;
	}

}
