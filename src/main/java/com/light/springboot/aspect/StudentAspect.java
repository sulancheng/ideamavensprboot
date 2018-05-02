package com.light.springboot.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator
 * on 2018/5/2.
 */
@Aspect
@Component//aop拦截获取各种数据的实现
public class StudentAspect {
    private final static Logger logger = LoggerFactory.getLogger(StudentAspect.class);
    @Pointcut("execution(public * com.light.springboot.controller.TestController.*(..))")//公用的方法
    public void aoplog(){
    }
    @Pointcut("execution(public * com.light.springboot.controller.TestController.getUser(..))")//公用的方法
    public void aoplogone(){
    }
    @Before("aoplog()")
    public void logbeforeAll(){
        logger.info("aop调用全部的logbeforeAll");
    }
    //
    @Before("aoplogone()")
    public void logbeforeOne(JoinPoint joinPoint){
        logger.info("aop调用getUserlogbeforeOne");
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        //url
        logger.info("url={}",request.getRequestURL());

        logger.info("method={}",request.getMethod());
        //ip
        logger.info("ip={}",request.getRemoteAddr()+"  port=" +request.getRemotePort()+"  host=" +request.getRemoteHost());

        //类方法
        logger.info("class_method={}",joinPoint.getSignature()
        .getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //参数
        logger.info("args={}",joinPoint.getArgs());

    }
    @After("aoplogone()")
    public void logafterOne(){
        logger.info("aop调用getUserlogafterOne");
    }
    @AfterReturning(returning = "object",pointcut = "aoplog()")//返回的参数拦截
    public void doAfterReturning(Object object){
        if (object==null)return;
        logger.info("doAfterReturning={}",object.toString());
    }
}
