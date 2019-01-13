package com.yanger.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yanger.book.dao.BookDao;
import com.yanger.book.po.Book;
import com.yanger.book.vo.BookVo;

@Service
@Transactional
public class BookService {
	
	@Autowired
	private BookDao bookDao;
	
	/**
	 * 插入书籍
	 * @author YangHao  
	 * @time 2019年1月13日-下午4:22:55
	 * @param bookVo
	 */
	public void insertBook(BookVo bookVo) throws Exception{
		Book book = new Book();
		book.setName(bookVo.getName());
		book.setAuthor(bookVo.getAuthor());
		book.setPrice(bookVo.getPrice());
		bookDao.insert(book);
	}
	
	/**
	 * 根据主键删除书籍
	 * @author YangHao  
	 * @time 2019年1月13日-下午4:24:11
	 * @param id
	 */
	public void deleteBook(Integer id) throws Exception {
		bookDao.delete(id);
	}
	
	/**
	 * 更改书籍信息
	 * @author YangHao  
	 * @time 2019年1月13日-下午4:24:42
	 * @param id
	 */
	public void uptateBook(BookVo bookVo) throws Exception {
		Book book = new Book();
		book.setId(bookVo.getId());
		book.setName(bookVo.getName());
		book.setAuthor(bookVo.getAuthor());
		book.setPrice(bookVo.getPrice());
		bookDao.update(book);
	}
	
	/**
	 * 根据书籍查找书籍
	 * @author YangHao  
	 * @time 2019年1月13日-下午4:28:39
	 * @param bookCode
	 * @param password
	 * @return
	 */
	public Book findBook(String name) throws Exception {
		return bookDao.find(name);
	}
	
}
