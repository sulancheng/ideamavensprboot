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
    @Pointcut("execution(public * com.light.springboot.controller.*.*(..))")//所有的controller ,记录访问记录。
    public void alllog(){
    }

    @Pointcut("execution(public * com.light.springboot.controller.TestController.*(..))")//所有的TestController ,记录访问记录。
    public void aoptestConlog(){
    }
    @Pointcut("execution(public * com.light.springboot.controller.TestController.getUser(..))")//公用的方法
    public void aoplogone(){
    }

    ThreadLocal<Long> startTime = new ThreadLocal<>();
    @Before("alllog()")
    public void logbeforeAllController(JoinPoint joinPoint){
        startTime.set(System.currentTimeMillis());
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        logger.info("START----------------------------------------------------------------------------------------------");
        logger.info("log beforeOneurl={}",request.getRequestURL());
        logger.info("log beforeOnemethod={}",request.getMethod());
        logger.info("log beforeIP={} : " + request.getRemoteAddr());
        logger.info("log beforeOneclass_method={}",joinPoint.getSignature()
                .getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        logger.info("log beforeOneargs={}",joinPoint.getArgs());
        logger.info("               -------------------------------------------------------------------------------------");
    }

//    @Before("aoptestConlog()")
//    public void logbeforeAll(){
//        logger.info("aop调用全部的logbeforeAll");
//    }
    //
//    @Before("aoplogone()")
//    public void logbeforeOne(JoinPoint joinPoint){
//        logger.info("logbeforeOneaop调用getUserlogbeforeOne");
//        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = servletRequestAttributes.getRequest();
//        //url
//        logger.info("logbeforeOneurl={}",request.getRequestURL());
//
//        logger.info("logbeforeOnemethod={}",request.getMethod());
//        //ip
//        logger.info("logbeforeOneip={}",request.getRemoteAddr()+"  port=" +request.getRemotePort()+"  host=" +request.getRemoteHost());
//
//        //类方法
//        logger.info("logbeforeOneclass_method={}",joinPoint.getSignature()
//        .getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
//        //参数
//        logger.info("logbeforeOneargs={}",joinPoint.getArgs());
//    }
//    @After("aoplogone()")
//    public void logafterOne(){
//        logger.info("logbeforeOneaop调用getUserlogafterOne");
//    }
    @AfterReturning(returning = "object",pointcut = "alllog()")//返回的参数拦截
    public void doAfterReturning(Object object){
        if (object==null)return;
        logger.info("log beforeOnedo AfterReturning={}",object.toString());
        // 处理完请求，返回内容
        logger.info("log beforeOnedo AfterReturning TIME : " + (System.currentTimeMillis() - startTime.get()));
        logger.info("END----------------------------------------------------------------------------------------------");
    }
}
