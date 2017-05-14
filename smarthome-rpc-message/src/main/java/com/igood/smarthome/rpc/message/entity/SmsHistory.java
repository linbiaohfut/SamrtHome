package com.igood.smarthome.rpc.message.entity;

import com.igood.smarthome.rabbitmq.enums.MsgType;

import java.util.Date;

/**
 * Created by linzhuowei on 2017/5/14.
 */
public class SmsHistory {
    private String phone;       // 手机号
    private String content;     // 发送的内容
    private int timeout;        // 超时时间
    private MsgType type;       // 类型
    private String sender;      // 发送者 默认：system
    private String receiverId;  // 接受者
    private String userIp;      // IP地址
    private String validate;    // 验证码

    // 当天的开始时间
    private Date startOfDay;

    public Date getStartOfDay() {
        return startOfDay;
    }

    public void setStartOfDay(Date startOfDay) {
        this.startOfDay = startOfDay;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public MsgType getType() {
        return type;
    }

    public void setType(MsgType type) {
        this.type = type;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public String getValidate() {
        return validate;
    }

    public void setValidate(String validate) {
        this.validate = validate;
    }
}
