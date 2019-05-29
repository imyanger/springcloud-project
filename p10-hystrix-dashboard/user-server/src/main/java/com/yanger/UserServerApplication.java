package com.yanger;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import brave.sampler.Sampler;

@EnableHystrixDashboard // hystrix仪表盘支持，访问地址 http://localhost:10820/actuator/hystrix.stream、http://localhost:10820/hystrix
@EnableHystrix // 开启hystrix功能
@EnableFeignClients // @EnableFeignClients注解，用来为应用开启Feign相关功能
@EnableEurekaClient
@SpringBootApplication // 声明一个springboot项目
@ComponentScan("com.yanger.*") // 扫描注解的路径，可不配置，不配置则默认扫描启动类同包下的文件
@MapperScan("com.yanger.*.dao") // 引入项目中mybatis的mapper类
public class UserServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServerApplication.class, args);
	}
	
	@Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
	
	// zipkin依赖支持，不注入zipkin无法发现服务
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

}

