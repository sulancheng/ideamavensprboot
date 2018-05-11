package com.light.springboot.config;

import com.light.springboot.Interceptor.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Autowired
	private MyInterceptor myInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(myInterceptor) // 指定拦截器类
				.addPathPatterns("/test/map");
				//.excludePathPatterns("/test/user");// 指定不拦截
	}
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    //在这里设置spring boot配置静态资源访问路径：addResourceLocations指的是文件放置的目录，addResoureHandler指的是对外暴露的访问路径
//        registry.addResourceHandler("/static/js/**").addResourceLocations("classpath:/static/js/");
	}
	/**
	 * 以前要访问一个页面需要先创建个Controller控制类，再写方法跳转到页面
	 * 在这里配置后就不需要那么麻烦了，直接访问http://localhost:8080/toLogin就跳转到login.jsp页面了
	 * @param registry
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
//		registry.addViewController("/toLogin").setViewName("login");
	}

	/**
	 * 作用是解决跨域的问题
	 * @param registry
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/test/hellky/**")//也成功
				.allowedOrigins("http://localhost:63343");// 允许 8088 端口访问
	}


//	@Bean//主要用于Configuration与component注解中
//	public HttpMessageConverters fastJsonHttpMessageConverters() {
//		FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
//
//		FastJsonConfig fastJsonConfig = new FastJsonConfig();
//		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
//
//		fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
//
//		HttpMessageConverter<?> converter = fastJsonHttpMessageConverter;
//		return new HttpMessageConverters(converter);
//
//	}
}
