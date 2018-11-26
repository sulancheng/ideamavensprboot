package com.light.springboot.controller;

import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by Administrator
 * on 2018/11/23 0023.
 */
@Api(value = "开始表单数据上传", tags = { "开始表单数据上传tag" })
@Controller  //@RestController 的意思就是controller里面的方法都以json格式输出，不用再写什么jackjson配置的了！
@RequestMapping("form")
public class FormController {
    private final static Logger logger = LoggerFactory
            .getLogger(FormController.class);
    @GetMapping("")
    public Object deault() {
        return "formuser";
    }
    @PostMapping("/userpas")
    public Object getUserpas(@RequestParam("username") String username, @RequestParam("password") String password, Map<String, Object> map) {
        logger.info("开始表单数据上传:",username+"    "+password);
        map.put("ziyuan",username+"and"+password);
        return "formuser";
    }
}
