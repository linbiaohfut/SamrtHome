package com.igood.smarthome.rabbitmq.model;

import com.igood.smarthome.rabbitmq.enums.MsgType;

import java.io.Serializable;
import java.util.Date;

/**
 * 短信消息
 * Created by linzhuowei on 2017/5/14.
 */
public class SmsModel implements Serializable {
    private static final long serialVersionUID = -888661824696905703L;
    private String phone;       // 手机号
    private String userIp;      // IP地址
    private MsgType type;
    private Date date;
    private String content;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public MsgType getType() {
        return type;
    }

    public void setType(MsgType type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return new org.apache.commons.lang3.builder.ToStringBuilder(this)
                .append("phone", phone)
                .append("userIp", userIp)
                .append("type", type)
                .append("date", date)
                .append("content", content)
                .toString();
    }
}

