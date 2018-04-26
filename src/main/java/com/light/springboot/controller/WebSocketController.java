package com.light.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator
 * on 2018/4/26.
 */
@Controller
public class WebSocketController {
    @RequestMapping("/con")
    public String conn() {
        return "websocket";
    }
}
