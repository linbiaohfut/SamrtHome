package com.igood.smarthome.service.device.service;

import com.igood.smarthome.rpc.device.service.RpcGatewayService;

/**
 * 智能网关服务
 *
 * @author linzhuowei
 * @create 2017/5/27
 */
public class GatewayService extends DeviceService implements RpcGatewayService {
    @Override
    public int deleteChildDevices(String gatewayId) {
        return 0;
    }
}
