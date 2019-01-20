package com.yanger.book.po;

import java.io.Serializable;

import lombok.Data;

@Data
public class Book implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// 主键id
	private Integer id;
	
	// 书籍名称
	private String name;
	
	// 书籍作者
	private String author;
	
	// 价格
	private Double price;

}
