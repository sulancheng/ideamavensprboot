package com.light.springboot.controller;

import bean.Result;
import com.light.springboot.utils.ResultUtils;
import com.light.springboot.websocketconfig.WebSocketServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.TextMessage;

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

    @PostMapping("/send")
    @ResponseBody
    public Result send(@RequestBody String data) {
        WebSocketServer.broadcast((new TextMessage(data)));
        return ResultUtils.sucess(data);
    }
}
