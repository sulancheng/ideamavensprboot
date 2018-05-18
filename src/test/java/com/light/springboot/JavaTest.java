package com.light.springboot;

import com.light.springboot.javatest.Animal;
import com.light.springboot.javatest.Cat;
import com.light.springboot.javatest.Dog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Administrator
 * on 2018/5/8.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JavaTest {
    private final static Logger logger = LoggerFactory.getLogger(JavaTest.class);
    @Test
    public void splitdemo(){
        String str="dsa,ds,";
        String[] split = str.split(",");

        logger.info("split后数据的长度:"+split.length);
    }
    @Test
    public void timerDemo(){
        Animal cat = new Cat();

        cat.eat();
        cat.work();
        Animal animal = new Animal() {
            @Override
            public void work() {
                logger.info("匿名cat儿子");
            }

            @Override
            public void eat() {
//                super.eat();
                logger.info("匿名cat儿子吃东西");
            }
        };
        animal.eat();
        animal.work();
        Animal dog = new Dog();
        dog.work();
        dog.eat();
    }
}
