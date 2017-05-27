package com.igood.smarthome.rpc.device.enums;

import com.igood.common.entity.enums.IntEnum;

/**
 * Created by Administrator on 2017/5/25.
 */
public enum PasswordType implements IntEnum<PasswordType> {

    ADMINISTRATOR(0, "管理员密码"),
    DIGITAL(1, "数字密码"),//锁面板上按键输入的数字密码
    CARD(2, "卡片密码"),//用磁卡刷卡开锁
    FINGERPRINT(3, "指纹密码");
    public int code;
    public String name;
    PasswordType(int code, String name) {
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
        for (PasswordType c: PasswordType.values()) {
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