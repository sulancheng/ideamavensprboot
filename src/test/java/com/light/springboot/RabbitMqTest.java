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

import java.util.Arrays;


/**
 * Created by Administrator
 * on 2019/1/17 0017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqTest {
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

//        int[] arr = new int[] { 5, 3, 6, 2, 10, 2, 1 };
//        int[] arr2 = new int[] { 5, 3, 6, 2, 10, 2, 1 };
//        selectSort2(arr);
//        maop(arr2);
    }

    public void selectSort2(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        logger.info("选择排序"+Arrays.toString(arr));
    }
    public void maop(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        logger.info("冒泡排序"+Arrays.toString(arr));
    }
}
