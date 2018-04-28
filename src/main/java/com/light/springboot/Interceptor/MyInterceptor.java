package com.light.springboot.Interceptor;


import com.light.springboot.utils.HttpHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class MyInterceptor implements HandlerInterceptor {
    private final static Logger logger = LoggerFactory.getLogger(MyInterceptor.class);
    @Autowired
    HttpHelper myhttphelper;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        String jsondata = myhttphelper.readJson(request);
        logger.info("preHandlegetdata=" + jsondata);
        logger.info("========preHandle=========");
        request.setAttribute("mydata",jsondata);//通过这个传给controll
        request.setAttribute("startTime", System.currentTimeMillis());
        return true; // 如果false，停止流程，api被拦截
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        logger.info("========postHandle=========");
        Long start = (Long) request.getAttribute("startTime");
        logger.info("耗时:" + (System.currentTimeMillis() - start));
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        logger.info("========afterCompletion=========");
        Long start = (Long) request.getAttribute("startTime");
        logger.info("耗时:" + (System.currentTimeMillis() - start));
    }

}
