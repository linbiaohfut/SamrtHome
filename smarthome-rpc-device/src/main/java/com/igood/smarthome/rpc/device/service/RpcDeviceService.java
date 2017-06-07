package com.igood.smarthome.rpc.device.service;

import com.github.pagehelper.PageInfo;
import com.igood.smarthome.common.model.Page;
import com.igood.smarthome.rpc.device.entity.Device;
import com.igood.smarthome.rpc.device.enums.DeviceType;

import java.util.List;

/**
 * 设备服务接口
 * Created by Administrator on 2017/4/23.
 */
public interface RpcDeviceService {
    /**
     *  添加设备信息
     * @param device
     * @return 插入的行数
     */
    int addDevice(Device device);

    /**
     * 根据ID获取设备信息
     * @param id
     * @return
     */
    Device getDeviceById(String id);

    /**
     * 根据序列号获取设备信息
     * @param serial 序列号
     * @return
     */
    Device getDeviceBySerial(String serial);
    /**
     * 根据ID获取设备信息并带它拥有的子设备列表信息
     * @param id
     * @return
     */
    Device getDevicewithChildsById(String id);

    /**
     * 根据家庭ID查询该家庭拥有的所有为父节点的的设备列表
     * @return
     */
    Page<Device> getParentDevices(String homeId, int pageNum, int pageSize);
    /**
     * 根据父设备ID该设备拥有的所有为子节点的的设备列表
     * @return
     */
    Page<Device> getChildDevices(String parentId, int pageNum, int pageSize);


    /**
     * 根据产品类型ID获取该类型的所有设备
     * @param productTypeId
     * @return
     */
    Page<Device> getDevicesByType(String productTypeId, int pageNum, int pageSize);
    /**
     * 更新设备名称
     * @param id
     * @return 如果影响的行数大于1，表示更新记录行数
     */
    int updateNameById(String id, String name);

    /**
     * 更新设备图片
     * @param id
     * @return 如果影响的行数大于1，表示更新记录行数
     */
    int updatePictureById(String id,String picturePath);

    /**
     * 根据ID删除设备
     * @param id
     */
    void deleteDeviceById(String id);

    /**
     * 设备与家庭进行绑定
     * 通过扫二维码或局域网获取设备信息如序列号等，而设备ID是数据库插入时生成的，因此绑定时只能通过设备序列号来标识唯一一个设备
     * @param serial 设备序列号
     * @param homeId 家庭ID
     * @return
     */
    int bindHome(String serial,String homeId);

    /**
     * 解除设备与家庭绑定关系
     * @param deviceId 设备ID
     * @return
     */
    int unBindHome(String deviceId);
}
