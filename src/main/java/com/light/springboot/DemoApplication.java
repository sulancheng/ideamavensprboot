package com.light.springboot;

import com.light.springboot.websocketconfig.SocketServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;


@ComponentScan(basePackages =  "com.light.springboot")
@SpringBootApplication
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
