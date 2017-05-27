package com.igood.smarthome.common.utils;

public class StringUtils extends org.apache.commons.lang3.StringUtils {
    /**
     * 隐藏手机号 中间六位
     * @param phone
     * @return
     */
    public static String hidePhone(String phone) {
        return substring(phone, 0, 3) + "******" + substring(phone, phone.length()-2, phone.length());
    }
}