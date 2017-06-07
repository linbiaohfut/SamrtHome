package com.igood.smarthome.service.device.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.igood.common.entity.enums.Status;
import com.igood.smarthome.common.model.Page;
import com.igood.smarthome.rpc.device.entity.Device;
import com.igood.smarthome.rpc.device.enums.DeviceType;
import com.igood.smarthome.rpc.device.service.RpcDeviceService;
import com.igood.smarthome.service.device.dao.DeviceDaoMapper;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * 智能设备服务实现类
 *
 * @author linzhuowei
 * @create 2017/5/23
 */
@Service("deviceService")
public class DeviceService implements RpcDeviceService {
    private static final Logger logger = LoggerFactory.getLogger(DeviceService.class);

    @Autowired
    private DeviceDaoMapper deviceDaoMapper;
    @Override
    public int addDevice(Device device) {
        device.preInsert();
        return deviceDaoMapper.save(device);
    }

    @Override
    public Device getDeviceById(String id) {
        return deviceDaoMapper.load(new Device(id));
    }

    @Override
    public Device getDeviceBySerial(String serial) {
        Device device = new Device();
        device.setSerial(serial);
        return deviceDaoMapper.load(device);
    }

    @Override
    public Device getDevicewithChildsById(String id) {
        return deviceDaoMapper.getDevicewithChildsById(id);
    }

    @Override
    public Page<Device> getParentDevices(String homeId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Device> devices = deviceDaoMapper.getParentDevices(homeId);

        try {
            PageInfo<Device> devicePageInfo = new PageInfo<>(devices);
            Page<Device> devicePage = new Page<>();
            BeanUtils.copyProperties(devicePage, devicePageInfo);
            devicePage.setList(devices);
            return devicePage;
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public Page<Device> getDevicesByType(String productTypeId, int pageNum, int pageSize) {

        Device device = new Device();
        device.setProductTypeId(productTypeId);
        PageHelper.startPage(pageNum, pageSize);
        List<Device> devices = deviceDaoMapper.loadAll(device);
        PageInfo<Device> devicePageInfo = new PageInfo<>(devices);

        try {
            Page<Device> devicePage = new Page<>();
            BeanUtils.copyProperties(devicePage, devicePageInfo);
            devicePage.setList(devices);
            return devicePage;
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Page<Device> getChildDevices(String parentId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Device device = new Device();
        device.setParentId(parentId);
        List<Device> devices = deviceDaoMapper.loadAll(device);
        PageInfo<Device> devicePageInfo = new PageInfo<>(devices);
        try {
            Page<Device> devicePage = new Page<>();
            BeanUtils.copyProperties(devicePage, devicePageInfo);
            devicePage.setList(devices);
            return devicePage;
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int updateNameById(String id, String name) {
        Device device = new Device(id);
        device.setName(name);
        return deviceDaoMapper.update(device);
    }

    @Override
    public int updatePictureById(String id, String picturePath) {
        Device device = new Device(id);
        device.setPicture(picturePath);
        return deviceDaoMapper.update(device);
    }

    @Override
    public void deleteDeviceById(String id) {
        Device device = new Device(id);
        device.setStatus(Status.DELETE);
        deviceDaoMapper.update(device);
    }

    @Override
    public int bindHome(String serial, String homeId) {
        Device device = new Device();
        device.setHomeId(homeId);
        device.setSerial(serial);
        device.preInsert();
        return deviceDaoMapper.bindHome(device);
    }

    @Override
    public int unBindHome(String deviceId) {
        Device device = new Device(deviceId);
        device.setHomeId("0");
        return deviceDaoMapper.update(device);
    }
}
