package com.light.springboot.utils;

import bean.Result;

/**
 * Created by Administrator
 * on 2018/5/2.
 */

public class ResultUtils {
    public static Result sucess(String msg,Object object){
        Result<Object> objectResult = new Result<>();
        objectResult.setCode(0);
        objectResult.setMsg(msg);
        objectResult.setData(object);
        return objectResult;
    }
    public static Result error(Integer code,String erromsg){
        Result<Object> objectResult = new Result<>();
        objectResult.setMsg(erromsg);
        objectResult.setCode(code);
        return objectResult;
    }

    public static Result sucess(String msg){
        return sucess(msg,null);
    }
    public static Result erro(String erromsg){
       return error(1,erromsg);
    }
}
