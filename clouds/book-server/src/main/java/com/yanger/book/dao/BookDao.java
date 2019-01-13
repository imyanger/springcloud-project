package com.yanger.book.dao;

import org.apache.ibatis.annotations.Mapper;

import com.yanger.book.po.Book;

@Mapper
public interface BookDao {
	
	/**
	 * 新增书籍
	 * @author YangHao  
	 * @time 2019年1月13日-下午3:17:30
	 */
	void insert(Book book);
	
	/**
	 * 删除书籍
	 * @author YangHao  
	 * @time 2019年1月13日-下午3:18:13
	 */
	void delete(Integer id);
	
	/**
	 * 修改书籍
	 * @author YangHao  
	 * @time 2019年1月13日-下午3:18:56
	 */
	void update(Book book);
	
	/**
	 * 查询书籍
	 * @author YangHao  
	 * @time 2019年1月13日-下午3:19:24
	 * @return
	 */
	Book find(String name);
	
}
