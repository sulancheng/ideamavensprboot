package com.light.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import test.SellTicketImpl;

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
        SellTicketImpl sellTicket = new SellTicketImpl();
        new Thread(sellTicket).start();
    }
}
