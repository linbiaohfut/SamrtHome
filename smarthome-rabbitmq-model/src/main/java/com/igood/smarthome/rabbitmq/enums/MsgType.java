package com.igood.smarthome.rabbitmq.enums;

/**
 * 消息类型
 * Created by linzhuowei on 2017/5/14.
 */
public enum MsgType {
    VALIDATE("验证码"),
    NOTICE_CASH_COMSUME("现金消费"),
    ACTIVITY("活动");

    private String name;
    MsgType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
