package com.igood.smarthome.service.rabbitmq;

import com.igood.smarthome.rpc.rabbitmq.service.RpcRabbitSmsService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * Desc: 消息列队  生产者
 * Date: 2017/4/25
 */
@Service("rabbitSmsService")
public class RabbitSmsService implements RpcRabbitSmsService {
    @Autowired
    private RabbitTemplate rabbitSmsTemplate;

    @Override
    public void sendValidate(Object data) {
        rabbitSmsTemplate.convertAndSend(VALIDATE, data);
    }

    @Override
    public void sendCashNotify(Object data) {
        rabbitSmsTemplate.convertAndSend(NOTICE, data);
    }
}