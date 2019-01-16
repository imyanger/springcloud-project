package com.yanger.book.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.yanger.book.po.Book;

@Mapper
public interface BookDao {
	
	/**
	 * @description 新增书籍
	 * @author YangHao  
	 * @time 2019年1月13日-下午3:17:30
	 */
	void insert(Book book);
	
	/**
	 * @description 删除书籍
	 * @author YangHao  
	 * @time 2019年1月13日-下午3:18:13
	 */
	void delete(@Param("id") Integer id);
	
	/**
	 * @description 修改书籍
	 * @author YangHao  
	 * @time 2019年1月13日-下午3:18:56
	 */
	void update(Book book);
	
	/**
	 * @description 查询书籍
	 * @author YangHao  
	 * @time 2019年1月13日-下午3:19:24
	 * @return
	 */
	Book find(@Param("name") String name);

	/**
	 * @description 根据id查找书籍
	 * @author YangHao  
	 * @time 2019年1月15日-下午11:48:52
	 * @param id
	 * @return
	 */
	Book findById(@Param("id") Integer id);
	
}
