package com.yanger;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;

import brave.sampler.Sampler;

@EnableHystrix
@EnableHystrixDashboard // 断路器仪表盘
@EnableEurekaClient // 注册服务到eureka上
@SpringBootApplication // 声明一个springboot项目
@ComponentScan("com.yanger.*") // 扫描注解的路径，可不配置，不配置则默认扫描启动类同包下的文件
@MapperScan("com.yanger.*.dao") // 引入项目中mybatis的mapper类
public class BookServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookServerApplication.class, args);
	}

	// zipkin依赖支持，不注入zipkin无法发现服务
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

	// 需要提供ServletRegistrationBean，不然仪表盘不显示
	// 但在user-server中无需添加也可显示，暂原因不明
	@Bean
	public ServletRegistrationBean getServlet() {
		HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
		registrationBean.setLoadOnStartup(1);
		registrationBean.addUrlMappings("/actuator/hystrix.stream");
		registrationBean.setName("HystrixMetricsStreamServlet");
		registrationBean.setName("HystrixMetricsStreamServlet");
		return registrationBean;
	}

}
