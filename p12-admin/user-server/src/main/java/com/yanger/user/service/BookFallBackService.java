package com.yanger.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.yanger.user.vo.BookVo;

@Component
public class BookFallBackService implements BookService{

	/**
	 * @description feign调用使用hystrix处理的熔断方法，当服务不可用时，会调用fallback实现类
	 * @author YangHao  
	 * @time 2019年1月16日-下午11:30:09
	 * @param ids
	 * @return
	 */
	@Override
	public List<BookVo> findByIds(String ids) {
		return new ArrayList<BookVo>(){{
			BookVo bookVo = new BookVo();
			bookVo.setName("获取图书失败，feign方式的hystrix熔断方法");
			add(bookVo);
		}};
	}

}
