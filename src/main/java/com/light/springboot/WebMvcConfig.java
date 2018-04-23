package com.light.springboot;

import com.light.springboot.Interceptor.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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
	    //在这里设置spring boot配置静态资源访问路径：
//        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
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
