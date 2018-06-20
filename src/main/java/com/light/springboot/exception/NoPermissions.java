package com.light.springboot.exception;

import com.light.springboot.enums.ResultEnum;

/**
 * Created by Administrator
 * on 2018/5/2.
 */

public class NoPermissions extends RuntimeException {
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public NoPermissions() {
        super(ResultEnum.NOPERMISSION.getMsg());
        this.code = ResultEnum.NOPERMISSION.getCode();
    }
}
