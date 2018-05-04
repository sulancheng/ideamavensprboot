package com.light.springboot.handle;

import com.light.springboot.exception.MyException;
import com.light.springboot.exception.NoPermissions;
import com.light.springboot.utils.ResultUtils;
import com.light.springboot.utils.UtilTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 如果项目前后端是通过 JSON 进行数据通信，则当出现异常时可以常用如下方式处理异常信息。
 * 编写一个类充当全局异常的处理类，需要使用 @ControllerAdvice 和 @ExceptionHandler 注解：
 *
 * @author Administrator
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {
    private final static Logger logger = LoggerFactory.getLogger(GlobalDefaultExceptionHandler.class);

    /**
     * 处理 Exception 类型的异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Object handle(Exception e, HttpServletRequest request, HttpServletResponse response) {
        //除了我们定义的异常只能返回json数据，当时页面时，我们可以返回自己定义的异常页面
        //试验成功 可以判断是不是ajax 请求
        //判断是否为ajax请求，默认不是
        boolean ajax = UtilTools.isAjax(request);
        if (!ajax) {
            ModelAndView modelAndView = new ModelAndView();
            logger.error("【自定义异常网页】 {}", e);//方便定位异常  成功
            modelAndView.addObject("exp",e);
            modelAndView.addObject("url",request.getRequestURL());
            modelAndView.setViewName("401");
            return modelAndView;
        }
        if (e instanceof MyException) {
            logger.error("【自定义异常】 {}", e);//方便定位异常  成功
            MyException myException = (MyException) e;
            return ResultUtils.error(myException.getCode(), "服务器罢工了," + myException.getMessage());
        } else if (e instanceof NoPermissions) {
            logger.error("【自定义异常无权限】 {}", e);//方便定位异常  成功
            NoPermissions myException = (NoPermissions) e;
            return ResultUtils.error(myException.getCode(), "服务器罢工了你去权限," + myException.getMessage());
        } else {
            logger.error("【系统异常】 {}", e);//方便定位异常  成功
            return ResultUtils.error(-1, "服务器罢工了," + e.getMessage());
        }
//			Map<String, Object> map = new HashMap<String, Object>();
//			map.put("code", 500);
//			map.put("msg", e.getMessage());
//			map.put("msglong", "出异常了");
//			return map;
    }
}
