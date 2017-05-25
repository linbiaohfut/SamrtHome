package com.igood.smarthome.rpc.device.enums;

import com.igood.common.entity.enums.IntEnum;

/**
 * Created by Administrator on 2017/5/23.
 */
public enum ConnectType implements IntEnum<ConnectType>{

    WIRED(0, "有线连接"),
    ZIBEE(1, "zibee通信"),
    NB_IoT(2, " NB-IoT"),
    WIFI(3, "WIFI"),
    SIM(4, "3/4/5G SIM");
    public int code;
    public String name;
    ConnectType(int code, String name) {
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
        for (ConnectType c: ConnectType.values()) {
            if (code == c.getCode())
                return c.name;
        }
        return null;
    }

    @Override
    public int getIntValue() {
        return this.code;
    }

}
