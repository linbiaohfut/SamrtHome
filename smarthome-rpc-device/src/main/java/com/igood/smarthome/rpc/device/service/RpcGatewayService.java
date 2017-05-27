package com.igood.smarthome.rpc.device.service;

/**
 * Created by Administrator on 2017/4/24.
 */
public interface RpcGatewayService {

    /**
     * 删除所有子设备
     * @return
     */
    int deleteChildDevices(String gatewayId);


}
