package com.light.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


//@ComponentScan(basePackages =  "com.light.springboot")
@SpringBootApplication
//@EnableAsync 开启异步
//@EnableScheduling
public class DemoApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DemoApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
//		//起socket服务
//		SocketServer server = new SocketServer();
//		server.startService(8889);

		//起socket服务
//		SocketServer server = new SocketServer();
//		server.startSocketServer(8889);

	}
}
