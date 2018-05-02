package com.light.springboot.exception;

/**
 * Created by Administrator
 * on 2018/5/2.
 */

public class NoPermissions extends RuntimeException {
    private Integer code = 2;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public NoPermissions() {
        super("无权限");
    }
}
