package com.yanger.user.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yanger.user.vo.BookVo;

@FeignClient("book-service") //添加@FeignClient注解，声明对book-service的调用
public interface BookService {
	
	@RequestMapping(value = "/book/{ids}", method = RequestMethod.GET)
	List<BookVo> findByIds(@PathVariable("ids") String ids);
	
}
