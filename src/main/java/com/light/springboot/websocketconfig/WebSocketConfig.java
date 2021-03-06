package com.light.springboot.websocketconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * Created by Administrator
 * on 2018/4/24.
 */

@Configuration
//@EnableWebSocket //这个关闭注销 才能使得定时任务正常运行。
public class WebSocketConfig implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(webSocketServer(), "/webSocketServer/*");
    }

    @Bean//主要用于Configuration与component注解中
    public WebSocketHandler webSocketServer() {
        return new WebSocketServer();
    }
}
