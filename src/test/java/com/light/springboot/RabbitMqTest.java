package com.light.springboot;

import com.light.springboot.entity.Order;
import com.light.springboot.rabbitmq.SuOrderSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * Created by Administrator
 * on 2019/1/17 0017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public  class RabbitMqTest {
    private final static Logger logger = LoggerFactory.getLogger(RabbitMqTest.class);
    @Autowired
    SuOrderSender suOrderSender;
    @Test
    public void testSendOrder() {
        Order order = new Order();
        order.setId(2);
        order.setMessageId("2019011716307");
        order.setName("老子会打算");
        suOrderSender.sendSuOrder(order);
    }
}
