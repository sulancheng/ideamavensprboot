package com.light.springboot.jpa;

import bean.Result;

import java.util.List;

/**
 * Created by Administrator
 * on 2018/4/25.
 */

public interface BeanService<T> {
    public abstract void testQuery();

    public abstract List<DbResponeBean> mQuerylianhcx();

    public abstract Result addBean(T t) throws Exception;

    public abstract List<T> findAll();
}
