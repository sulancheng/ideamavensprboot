package com.light.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class DemoApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DemoApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	/**
	 * 如果项目前后端是通过 JSON 进行数据通信，则当出现异常时可以常用如下方式处理异常信息。
	 * 编写一个类充当全局异常的处理类，需要使用 @ControllerAdvice 和 @ExceptionHandler 注解：
	 * 
	 * @author Administrator
	 *
	 */
	@ControllerAdvice
	public class GlobalDefaultExceptionHandler {

		/**
		 * 处理 Exception 类型的异常
		 * 
		 * @param e
		 * @return
		 */
		@ExceptionHandler(Exception.class)
		@ResponseBody
		public Map<String, Object> defaultExceptionHandler(Exception e) {

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("code", 500);
			map.put("msg", e.getMessage());
			map.put("msglong", "出异常了");
			return map;
		}
	}
}
