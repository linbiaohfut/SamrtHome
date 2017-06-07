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
    private String productId;//产品ID
    private String serial;//设备序列号
    private String softVersion;//软件版本号
    private ConnectType connectType;//联网方式
    private String parentId;
    private String homeId;

    private List<Device> ChildList;//子设备列表
    private String productTypeId;//产品类型ID

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


    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
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

    public String getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(String productTypeId) {
        this.productTypeId = productTypeId;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id='"+id+'\''+
                ", name='" + name + '\'' +
                ", picture='" + picture + '\'' +
                ", productId=" + productId +
                ", serial='" + serial + '\'' +
                ", softVersion='" + softVersion + '\'' +
                ", connectType=" + connectType +
                ", parentId='" + parentId + '\'' +
                ", homeId='" + homeId + '\'' +
                ", ChildList=" + ChildList +
                '}';
    }
}
