package com.yanger.user.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yanger.user.vo.BookVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RibbonService {

	@Autowired
	RestTemplate restTemplate;

	/**
	 * @description 根据id查找用户喜爱的书籍(通过ribbon调用)
	 * @author YangHao
	 * @time 2019年1月13日-下午5:32:34
	 * @param ids
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@HystrixCommand(fallbackMethod = "findByIdsFallback")
	public List<BookVo> findByIds(String ids) {
		BookVo[] bookVos = restTemplate.getForObject("http://book-server/book/" + ids, BookVo[].class);
		return Arrays.asList(bookVos);
	}

	/**
	 * @description ribbon调用使用hystrix处理的熔断方法，当服务不可用时，会调用fallbackMethod
	 * @author YangHao  
	 * @time 2019年1月16日-下午11:01:12
	 * @return
	 */
	public List<BookVo> findByIdsFallback(String ids) {
		return new ArrayList<BookVo>(){{
			log.info("获取图书失败，ribbon方式的hystrix熔断方法");
			BookVo bookVo = new BookVo();
			bookVo.setName("获取图书失败，ribbon方式的hystrix熔断方法");
			add(bookVo);
		}};
	}

}
