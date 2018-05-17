package com.light.springboot.javatest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by sucheng
 * on 2018/5/8.
 */

public class Dog extends Animal {
    private final static Logger logger = LoggerFactory.getLogger(Dog.class);
    @Override
    public void work() {
        logger.info("DOG看门");
    }

}
