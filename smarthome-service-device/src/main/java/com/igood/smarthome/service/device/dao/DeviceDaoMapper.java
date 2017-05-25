package com.igood.smarthome.service.device.dao;

import com.igood.smarthome.common.core.dao.BaseDaoMapper;
import com.igood.smarthome.rpc.device.entity.Device;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author linzhuowei
 * @create 2017/4/23
 */
@Repository
public interface DeviceDaoMapper extends BaseDaoMapper<Device> {
    Device getDevicewithChildsById(String id);

    /**
     * 根据家庭ID该家庭拥有的所有为父节点的的设备列表
     * @return
     */
    List<Device> getParentDevices(String homeId);

    //int bindHome(@Param("serial")String serial, @Param("homeId")String homeId);
    int bindHome(Device device);

}
