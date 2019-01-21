package com.yanger.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulServiceeFilter extends ZuulFilter {
	
	private static Logger log = LoggerFactory.getLogger(ZuulServiceeFilter.class);

	@Override
	public Object run() throws ZuulException {
		// 拦截处理
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		log.info("zuul请求路径：{}", request.getServletPath());
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	// 顺序
	@Override
	public int filterOrder() {
		return 0;
	}

	// 拦截类型
	@Override
	public String filterType() {
		return "pre";
	}

}
