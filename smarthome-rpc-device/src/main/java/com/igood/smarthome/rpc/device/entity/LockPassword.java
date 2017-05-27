package com.igood.smarthome.rpc.device.entity;

import com.igood.common.entity.DataEntity;
import com.igood.smarthome.rpc.device.enums.PasswordType;

import java.util.Date;

/**
 * 门锁密码实体类
 *
 * @author linzhuowei
 * @create 2017/4/25
 */
public class LockPassword extends DataEntity<LockPassword> {
    /**
     * 密码的索引
     */
    private int index;
    /**
     * 备注名
     */
    private String name;
    /**
     * 有效开始时间
     */
    private Date startTime;
    /**
     * 有效结束时间
     */
    private Date endTime;
    /**
     * 最大使用次数 临时密码在使用超过最大次数后就能不能开锁，长期密码最大使用次数为-1
     */
    private Integer useCountMax;

    private PasswordType passwordType;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getUseCountMax() {
        return useCountMax;
    }

    public void setUseCountMax(Integer useCountMax) {
        this.useCountMax = useCountMax;
    }

    public PasswordType getPasswordType() {
        return passwordType;
    }

    public void setPasswordType(PasswordType passwordType) {
        this.passwordType = passwordType;
    }
}
