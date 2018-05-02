package com.light.springboot.exception;

import com.light.springboot.enums.ResultEnum;

/**
 * Created by Administrator
 * on 2018/5/2.
 */

public class MyException extends RuntimeException {
    private Integer code;
    public MyException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
    public MyException(String msg,Integer code) {
        super(msg);
        this.code = code;
    }
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
