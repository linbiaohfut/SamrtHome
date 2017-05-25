package com.igood.common.entity.id;

import java.util.UUID;

public class IdGen {

    //private static SecureRandom random = new SecureRandom();

    /**
     * 封装JDK自带的UUID，中间无-分割
     * @return
     */
    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}