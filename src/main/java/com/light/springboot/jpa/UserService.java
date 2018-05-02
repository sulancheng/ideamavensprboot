package com.light.springboot.jpa;

import bean.Result;

import java.util.List;

/**
 * Created by Administrator
 * on 2018/4/25.
 */

public interface UserService<T> {
    public  void testQuery();

    public List<DbResponeBean> mQuerylianhcx();

    public Result addBean(T t) throws Exception;
}
