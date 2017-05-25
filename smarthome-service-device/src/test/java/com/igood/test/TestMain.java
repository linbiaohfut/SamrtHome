package com.igood.test;

import com.igood.smarthome.common.model.Page;
import com.igood.smarthome.rpc.device.entity.Device;
import com.igood.smarthome.rpc.device.enums.ConnectType;
import com.igood.smarthome.rpc.device.enums.DeviceType;
import com.igood.smarthome.rpc.device.service.RpcDeviceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author linzhuowei
 * @create 2017/5/24
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/spring-context.xml"})
public class TestMain {
    private static final Logger logger = LoggerFactory.getLogger(TestMain.class);

    @Autowired
    private RpcDeviceService deviceService;

    @Test
    public void testAddDevice(){
        /*Device device0 = new Device();
        device0.setName("智能门锁01");
        device0.setPicture("http://dl2.iteye.com/upload/attachment/0099/5373/e3e5ed37-aea8-3b65-974b-d1623e02ce71.jpg");
        device0.setDeviceType(DeviceType.LOCK);
        device0.setConnectType(ConnectType.ZIBEE);
        device0.setParentId("f633ae61c5ed43dbbb2555199ca16dc2");
        device0.setSerial("TX23456601");
        device0.setSoftVersion("1.0.1");
        deviceService.addDevice(device0);

        Device device1 = new Device();
        device1.setName("智能门锁02");
        device1.setPicture("http://dl2.iteye.com/upload/attachment/0099/5373/e3e5ed37-aea8-3b65-974b-d1623e02ce71.jpg");
        device1.setDeviceType(DeviceType.LOCK);
        device1.setConnectType(ConnectType.ZIBEE);
        device1.setParentId("f633ae61c5ed43dbbb2555199ca16dc2");
        device1.setSerial("TX23456602");
        device1.setSoftVersion("1.0.1");
        deviceService.addDevice(device1);

        Device device2 = new Device();
        device2.setName("智能插座01");
        device2.setPicture("http://dl2.iteye.com/upload/attachment/0099/5373/e3e5ed37-aea8-3b65-974b-d1623e02ce71.jpg");
        device2.setDeviceType(DeviceType.SOCKET_OUTLET);
        device2.setConnectType(ConnectType.ZIBEE);
        device2.setParentId("f633ae61c5ed43dbbb2555199ca16dc2");
        device2.setSerial("TX23456603");
        device2.setSoftVersion("1.1.8");
        deviceService.addDevice(device2);

        Device device3 = new Device();
        device3.setName("智能插座02");
        device3.setPicture("http://dl2.iteye.com/upload/attachment/0099/5373/e3e5ed37-aea8-3b65-974b-d1623e02ce71.jpg");
        device3.setDeviceType(DeviceType.SOCKET_OUTLET);
        device3.setConnectType(ConnectType.ZIBEE);
        device3.setParentId("f633ae61c5ed43dbbb2555199ca16dc2");
        device3.setSerial("TX23456604");
        device3.setSoftVersion("1.1.8");
        deviceService.addDevice(device3);*/

        /*Device device0 = new Device();
        device0.setName("智能摄像头01");
        device0.setPicture("http://dl2.iteye.com/upload/attachment/0099/5373/e3e5ed37-aea8-3b65-974b-d1623e02ce71.jpg");
        device0.setDeviceType(DeviceType.CAMERA);
        device0.setConnectType(ConnectType.WIFI);
        device0.setSerial("TX23456605");
        device0.setSoftVersion("1.0.8");
        device0.setHomeId("e96e834db53f4cf496404c0eb5f9ce4b");
        deviceService.addDevice(device0);*/


    }
    @Test
    public void testGetDevice(){
        System.out.println(deviceService.getDeviceById("0bd8088e60d144a0bb84087227b2c91a"));
    }
    @Test
    public void testGetBySerial(){
        Device device = deviceService.getDeviceBySerial("TX23456608");
        logger.error("=======>"+device);
    }
    @Test
    public void testDevicewithChilds(){
        System.out.println(deviceService.getDevicewithChildsById("f633ae61c5ed43dbbb2555199ca16dc2"));
    }

    @Test
    public void testGetParentDevices(){
        System.out.println(deviceService.getParentDevices("e96e834db53f4cf496404c0eb5f9ce4b",1,10));
    }

    @Test
    public void testGetDevicesByType(){
        Page<Device> devicePage = deviceService.getDevicesByType(DeviceType.LOCK,1,10);

        logger.error("=======>"+devicePage+"");
        List<Device> devices = devicePage.getList();
        for (Device d:devices) {
            logger.error("=======>"+d);
        }
        //System.out.println(deviceService.getDevicesByType(DeviceType.LOCK,1,1));
    }
    @Test
    public void testUpdateNameById(){
        deviceService.updateNameById("2e882a7f59734627bf7fee58d6ca518a","智能门锁03");
    }

    @Test
    public void testBindHome(){
        deviceService.bindHome("TX23456608","e96e834db53f4cf496404c0eb5f9ce4b");
    }

    @Test
    public void testUnBindHome(){
        deviceService.unBindHome("04dcbbe48570430db46ca9a12803eec9");
    }


}
