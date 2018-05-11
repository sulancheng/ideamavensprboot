package com.light.springboot.controller;

/**
 * Created by Administrator
 * on 2018/5/11.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller  //@RestController 的意思就是controller里面的方法都以json格式输出，不用再写什么jackjson配置的了！
@RequestMapping("ticket")
public class TicketController {

}
