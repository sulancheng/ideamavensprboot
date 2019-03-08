package com.light.springboot.rabbitmq;

import com.light.springboot.entity.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator
 * on 2019/1/17 0017.
 */
@Component
public class SuOrderSender {
    /***
     * username : susu
     * password :123456
     */
    private final static Logger logger = LoggerFactory.getLogger(SuOrderSender.class);
    @Autowired
    private RabbitTemplate rabbitTemplate;
//    @Autowired
//    private BrokerMessageLogMapper brokerMessageLogMapper;
    final RabbitTemplate.ConfirmCallback confirmCallback = (CorrelationData correlationData, boolean b, String s) -> {
        logger.info("correlationData",correlationData);
        String id = correlationData.getId();
        if (b){
            //如果confirm返回成功，则进行更新

        }
    };
    public void sendSuOrder(Order order){
        rabbitTemplate.setConfirmCallback(confirmCallback);
        CorrelationData correlationData = new CorrelationData();
        correlationData.setId(order.getMessageId());
        rabbitTemplate.convertAndSend(
                "suorder-exchange",
                "suorder.test",
                order,
                correlationData //消息唯一的id
        );
    }
}
