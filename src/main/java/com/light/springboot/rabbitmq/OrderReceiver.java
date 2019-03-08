package com.light.springboot.rabbitmq;

import com.light.springboot.entity.Order;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * Created by Administrator
 * on 2019/3/8 0008.
 */
@Component
public class OrderReceiver {
    private final static Logger logger = LoggerFactory
            .getLogger(OrderReceiver.class);
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "suorder-queue",durable = "true"),
            exchange = @Exchange(value = "suorder-exchange",durable = "true",type = "topic"),
            key = "suorder.test"
    ))
    @RabbitHandler
    public void onOrderMessage(@Payload Order order, @Headers Map<String,Object> heads
            ,Channel channel) throws IOException {
        //消费者的收到信息：
        logger.info("收到的消息："+order.toString());
        //手工签收 必须手动确认签收
        Long deliveryTag = (Long) heads.get(AmqpHeaders.DELIVERY_TAG);
        channel.basicAck(deliveryTag,false);
    }
}
