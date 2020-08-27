package com.light.springboot.controller;

import com.light.springboot.utils.ResultUtils;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Random;

/**
 * Created by Administrator
 * on 2019/3/4 0004.
 */
@Api(value = "OneController", tags = {"正式的接口测试 短信 otp"})
@Controller  //@RestController 的意思就是controller里面的方法都以json格式输出，不用再写什么jackjson配置的了！
@RequestMapping("oncon")
public class OneController {
    private final static Logger logger = LoggerFactory
            .getLogger(OneController.class);

    @PostMapping("/getOtp")
    @ResponseBody
    public Object getOtp(HttpSession httpSession, HttpServletRequest request, @RequestParam("tel") String tel) {
        Random random = new Random();
        int i = random.nextInt(9999);
        i += 1000;
        String otpCode = String.valueOf(i);
        //将httpsession总的tel与otp做关联
        httpSession.setAttribute(tel, otpCode);
        String userAgent = request.getHeader("user-agent");
        logger.error("【网络请求来自于】 {}", userAgent);//方便定位异常  成功
        logger.info("ttel=" + tel + " & optcode =" + otpCode);
        return ResultUtils.sucess("userAgent = " + userAgent + "  ttel=" + tel + "   otpCode =" + otpCode);
    }
}
