package com.yanger.user.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.yanger.user.vo.BookVo;

@Service
public class RibbonService {
	
	@Autowired
    RestTemplate restTemplate;
	
	/**
	 * @description 根据id查找用户喜爱的书籍(通过ribbon调用)
	 * @author YangHao  
	 * @time 2019年1月13日-下午5:32:34
	 * @param userVo
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<BookVo> findByIds(String ids) {
		BookVo[] bookVos  = restTemplate.getForObject("http://book-server/book/" + ids, BookVo[].class);
		return Arrays.asList(bookVos);
	}

}
