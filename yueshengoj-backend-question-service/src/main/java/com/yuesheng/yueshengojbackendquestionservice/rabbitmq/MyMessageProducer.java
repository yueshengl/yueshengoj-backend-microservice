package com.yuesheng.yueshengojbackendquestionservice.rabbitmq;

import com.alibaba.nacos.shaded.com.google.errorprone.annotations.IncompatibleModifiers;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author: Dai
 * @Date: 2024/12/09 21:46
 * @Description: MyMessageProducer
 * @Version: 1.0
 */
@Component
public class MyMessageProducer {
    @Resource
    private RabbitTemplate rabbitTemplate;

    /**
     * 发送消息
     *
     * @param exchange
     * @param routingKey
     * @param message
     */
    public void sendMessage(String exchange, String routingKey, String message) {
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
    }

}
