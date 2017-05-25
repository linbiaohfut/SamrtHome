package com.igood.smarthome.rpc.rabbitmq.service;

/**
 * Rabbit短信生产者接口
 */
public interface RpcRabbitSmsService {

    String VALIDATE = "SMS-VALIDATE";
    String NOTICE = "SMS-NOTICE";
    String ACTIVITY = "SMS-ACTIVITY";

    /**
     * 发送验证码短信消息
     * @param msgData
     */
    void sendValidate(Object msgData);

    /**
     * 现金通知
     * @param msgData
     */
    void sendCashNotify(Object msgData);
}