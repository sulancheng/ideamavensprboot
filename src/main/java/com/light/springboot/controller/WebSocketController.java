package com.light.springboot.controller;

import bean.Result;
import com.light.springboot.utils.ResultUtils;
import com.light.springboot.websocketconfig.WebSocketServer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.TextMessage;

/**
 * Created by Administrator
 * on 2018/4/26.
 */
@Api(value = "WebSocketController", tags = { "websocket相关" })
@Controller
public class WebSocketController {
    @ApiOperation(value = "websocket连接", notes = "websocket连接")
//    @ApiImplicitParam(name = "susu", value = "后面的页数", required = true, dataType = "String")
    @GetMapping("/con")
    public String conn() {
        return "websocket";
    }
    @ApiOperation(value = "websocket发送数据", notes = "websocket发送数据")
    @ApiImplicitParam(name = "data", value = "数据内容", required = true, dataType = "String")
    @PostMapping("/send")
    @ResponseBody
    public Result send(@RequestBody String data) {
        WebSocketServer.broadcast((new TextMessage(data)));
        return ResultUtils.sucess(data);
    }
}
