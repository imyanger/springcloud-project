package com.yanger.user.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yanger.user.vo.BookVo;

// 注意服务名不要写错，异常：Load balancer does not have available server for client：xx
@FeignClient(value = "book-server",fallback = BookFallBackService.class) //添加@FeignClient注解，声明对book-server的调用
public interface BookService {
	
	@RequestMapping(value = "/book/{ids}", method = RequestMethod.GET)
	List<BookVo> findByIds(@PathVariable("ids") String ids);
	
}
