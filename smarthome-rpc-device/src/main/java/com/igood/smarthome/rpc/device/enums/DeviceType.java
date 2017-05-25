package com.igood.smarthome.rpc.device.enums;

import com.igood.common.entity.enums.IntEnum;

/**
 * 设备类型枚举
 *
 * @author linzhuowei
 * @create 2017/4/22
 */
public enum  DeviceType implements IntEnum<DeviceType> {

    GATEWAY(0, "智能网关"),
    LOCK(1, "智能锁"),
    MAGNETOMETER(2, "智能门磁"),
    SWITCHERS(3, "智能开关"),
    CAMERA(4, "智能摄像头"),
    GAS(5, "煤气报警器"),
    FORMALDEHYDE(6, "甲醛报警器"),
    SMOKE(7, "烟雾报警器"),
    INFRARED(8, "红外转发器"),
    SOCKET_OUTLET(9, "智能插座");
    public int code;
    public String name;
    DeviceType(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String fromCode(int code) {
        for (DeviceType d: DeviceType.values()) {
            if (code == d.getCode())
                return d.name;
        }
        return null;
    }

    @Override
    public int getIntValue() {
        return this.code;
    }

}
