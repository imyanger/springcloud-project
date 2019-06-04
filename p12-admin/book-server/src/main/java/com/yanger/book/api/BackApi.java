package com.yanger.book.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("back")
public class BackApi {

	@HystrixCommand(fallbackMethod = "hiBack")
	@GetMapping("hi")
	public String home(@RequestParam(value = "name", defaultValue = "yanger") String name) {
		System.out.println("Hi, I am " + name);
		return "Hi, I am " + name;
	}

	public String hiBack(String name) {
		return "Sorry, " + name + ", server is down";
	}

}
