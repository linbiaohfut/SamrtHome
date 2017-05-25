package com.igood.smarthome.rpc.gateway.service;

import com.igood.smarthome.rpc.device.service.RpcDeviceService;

/**
 * Created by Administrator on 2017/4/24.
 */
public interface RpcGatewayService extends RpcDeviceService {

    /**
     * 删除所有子设备
     * @return
     */
    int deleteChildDevices(String gatewayId);


}
