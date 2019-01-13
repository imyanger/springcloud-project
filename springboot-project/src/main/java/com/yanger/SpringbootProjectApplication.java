package com.yanger;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication // 声明一个springboot项目
@ComponentScan("com.yanger.*") // 扫描注解的路径，可不配置，不配置则默认扫描启动类同包下的文件
@MapperScan("com.yanger.*.dao") // 引入项目中mybatis的mapper类
public class SpringbootProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootProjectApplication.class, args);
	}

}

