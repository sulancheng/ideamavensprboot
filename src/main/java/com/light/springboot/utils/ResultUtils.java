package com.light.springboot.utils;

import bean.Result;

/**
 * Created by Administrator
 * on 2018/5/2.
 */

public class ResultUtils {
    public static Result sucess(String msg,Object object,int progress){
        Result<Object> objectResult = new Result<>();
        objectResult.setCode(0);
        objectResult.setMsg(msg);
        objectResult.setData(object);
        objectResult.setProgress(progress);
        return objectResult;
    }
    public static Result error(Integer code,String erromsg){
        Result<Object> objectResult = new Result<>();
        objectResult.setMsg(erromsg);
        objectResult.setCode(code);
        return objectResult;
    }

    public static Result sucess(String msg){
        return sucess(msg,null,0);
    }
    public static Result sucess(String msg,Object object){
        return sucess(msg,object,0);
    }
    public static Result sucess(String msg,int progress){
        return sucess(msg,null,progress);
    }
    public static Result erro(String erromsg){
       return error(1,erromsg);
    }
}
