package com.light.springboot.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
@Component
public class MyInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out.println("========preHandle=========");
		request.setAttribute("startTime", System.currentTimeMillis());
		return true; // 如果false，停止流程，api被拦截
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("========postHandle=========");
		Long start = (Long) request.getAttribute("startTime");
		System.out.println("耗时:" + (System.currentTimeMillis() - start));
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

		System.out.println("========afterCompletion=========");
		Long start = (Long) request.getAttribute("startTime");
		System.out.println("耗时:" + (System.currentTimeMillis() - start));
		System.out.println(ex);
	}

}
