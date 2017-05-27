package com.igood.smarthome.rpc.message.entity;

import com.igood.common.entity.DataEntity;
import com.igood.smarthome.rabbitmq.enums.MsgType;

/**
 * 短信模版
 * @author linzhuowei
 * @create 2017/5/22
 */
public class SmsTemplate extends DataEntity<SmsTemplate> {
    private MsgType type;
    private String content;
    private int timeout;
    private boolean isEnable;

    public SmsTemplate() {
    }

    public SmsTemplate(MsgType type) {
        this.type = type;
        this.isEnable = true;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isEnable() {
        return isEnable;
    }

    public void setEnable(boolean enable) {
        isEnable = enable;
    }
}