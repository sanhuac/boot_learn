package com.huc.boot.util.rabbit;

import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ReturnCallback;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Auther: 胡丛
 * @Date: 2018/8/8 11:23
 * @Description: 消息生产者
 */
@Component
public class Sender implements RabbitTemplate.ConfirmCallback, ReturnCallback  {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void init() {
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.setReturnCallback(this);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (ack) {
            System.out.println("消息发送成功:" + correlationData);
        } else {
            System.out.println("消息发送失败:" + cause);
        }

    }

    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        System.out.println(message.getMessageProperties().getCorrelationIdString() + " 发送失败");

    }

    //发送消息，不需要实现任何接口，供外部调用。
    public  void send(Object msg){

        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());

        System.out.println("开始发送消息 : " + msg.toString());
        String response = rabbitTemplate.convertSendAndReceive("topicExchange", "key.1", msg.toString(), correlationId).toString();
        System.out.println("结束发送消息 : " + msg.toString());
        System.out.println("消费者响应 : " + response + " 消息处理完成");
    }
}
