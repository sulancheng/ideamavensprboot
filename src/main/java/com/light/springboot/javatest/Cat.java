package com.light.springboot.javatest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by sucheng
 * on 2018/5/8.
 */

public class Cat extends Animal {
    private final static Logger logger = LoggerFactory.getLogger(Cat.class);
    @Override
    public void work() {
        logger.info("cat抓鱼");
    }
    @Override
    public void eat(){
        logger.info("cat儿子");
    }
}
