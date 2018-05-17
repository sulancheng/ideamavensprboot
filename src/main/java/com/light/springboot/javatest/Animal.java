package com.light.springboot.javatest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by sucheng
 * on 2018/5/8.
 */

public abstract class Animal {
    private final static Logger logger = LoggerFactory.getLogger(Animal.class);
    public void eat(){
        logger.info("animal祖宗");
    }
    public abstract void work();
}
