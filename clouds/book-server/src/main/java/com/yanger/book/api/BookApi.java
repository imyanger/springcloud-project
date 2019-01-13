package com.yanger.book.api;

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
import com.yanger.book.po.Book;
import com.yanger.book.service.BookService;
import com.yanger.book.vo.BookVo;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@Slf4j //引入日志变量log
@RestController
@RequestMapping("book")
@Api // swagger文档支持接口，方便接口查看和调用
public class BookApi {
	
	@Autowired
	BookService bookService;
	
	/**
	 * 插入书籍
	 * @author YangHao  
	 * @time 2019年1月13日-下午5:29:52
	 * @param bookVo
	 * @return
	 */
	@PostMapping("insert")
	public ApiResponse<String> insertBook(@RequestBody BookVo bookVo) {
		ApiResponse<String> api = new ApiResponse<>();
		try {
			log.info("插入书籍{}", bookVo.toString());
			bookService.insertBook(bookVo);
		} catch (Exception e) {
			api.error("书籍插入异常");
			e.printStackTrace();
		}
		return api;
	}

	/**
	 * 删除书籍
	 * @author YangHao  
	 * @time 2019年1月13日-下午5:30:07
	 * @param bookVo
	 * @return
	 */
	@DeleteMapping("delete/{id}")
	public ApiResponse<String> deleteBook(@PathVariable Integer id) {
		ApiResponse<String> api = new ApiResponse<>();
		try {
			bookService.deleteBook(id);
		} catch (Exception e) {
			api.error("删除书籍异常");
			e.printStackTrace();
		}
		return api;
	}
	
	/**
	 * 更新书籍
	 * @author YangHao  
	 * @time 2019年1月13日-下午5:32:08
	 * @param bookVo
	 * @return
	 */
	@PostMapping("update")
	public ApiResponse<String> uptateBook(BookVo bookVo) {
		ApiResponse<String> api = new ApiResponse<>();
		try {
			bookService.uptateBook(bookVo);
		} catch (Exception e) {
			api.error("更新书籍异常");
			e.printStackTrace();
		}
		return api;
	}
	
	/**
	 * 根据书籍名查找书籍
	 * @author YangHao  
	 * @time 2019年1月13日-下午5:32:34
	 * @param bookVo
	 * @return
	 */
	@GetMapping("find")
	public ApiResponse<Book> findBook(@RequestParam String name) {
		ApiResponse<Book> api = new ApiResponse<>();
		try {
			Book book = bookService.findBook(name);
			api.setData(book);
		} catch (Exception e) {
			api.error("根据书籍名和密码查找书籍异常");
			e.printStackTrace();
		}
		return api;
	}
	
}
