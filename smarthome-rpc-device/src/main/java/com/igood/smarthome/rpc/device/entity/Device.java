package com.igood.smarthome.rpc.device.entity;


import com.igood.common.entity.DataEntity;
import com.igood.smarthome.rpc.device.enums.ConnectType;
import com.igood.smarthome.rpc.device.enums.DeviceType;

import java.util.List;

/**
 * 智能设备数据库模型
 *
 * @author linzhuowei
 * @create 2017/4/23
 */
public class Device extends DataEntity<Device> {
    private String name;//设备名称
    private String picture;//设备图片
    private DeviceType deviceType;//设备类型
    private String serial;//设备序列号
    private String softVersion;//软件版本号
    private ConnectType connectType;//联网方式
    private String parentId;
    private String homeId;
    private List<Device> ChildList;//子设备列表

    public Device(){}
    public Device(String id){
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public DeviceType getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getSoftVersion() {
        return softVersion;
    }

    public void setSoftVersion(String softVersion) {
        this.softVersion = softVersion;
    }

    public ConnectType getConnectType() {
        return connectType;
    }

    public void setConnectType(ConnectType connectType) {
        this.connectType = connectType;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public List<Device> getChildList() {
        return ChildList;
    }

    public void setChildList(List<Device> childList) {
        ChildList = childList;
    }

    public String getHomeId() {
        return homeId;
    }

    public void setHomeId(String homeId) {
        this.homeId = homeId;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id='"+id+'\''+
                ", name='" + name + '\'' +
                ", picture='" + picture + '\'' +
                ", deviceType=" + deviceType +
                ", serial='" + serial + '\'' +
                ", softVersion='" + softVersion + '\'' +
                ", connectType=" + connectType +
                ", parentId='" + parentId + '\'' +
                ", homeId='" + homeId + '\'' +
                ", ChildList=" + ChildList +
                '}';
    }
}
