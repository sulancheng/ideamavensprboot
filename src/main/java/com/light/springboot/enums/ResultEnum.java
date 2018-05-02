package com.light.springboot.enums;

/**
 * Created by Administrator
 * on 2018/5/2.
 */

public enum ResultEnum  {
    UNKNOW_ERROR(-1,"未知错误"),
    SUCCESS(0,"成功"),
    ERROR(1,"失败"),
    NOPERMISSION(2,"无权限"),
    ;
    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }


    public String getMsg() {
        return msg;
    }
}
