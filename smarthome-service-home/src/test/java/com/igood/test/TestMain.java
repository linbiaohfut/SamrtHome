package com.igood.test;

import com.igood.smarthome.rpc.home.entity.Home;
import com.igood.smarthome.rpc.home.service.RpcHomeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author linzhuowei
 * @create 2017/4/23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/spring-context.xml"})
public class TestMain {
    @Autowired
    private RpcHomeService homeService;

    @Test
    public void testAddHome() {
        Home home = new Home();
        home.setName("的规定发给对方");
        home.setPicture("http://dl2.iteye.com/upload/attachment/0099/5373/e3e5ed37-aea8-3b65-974b-d1623e02ce71.jpg");
        homeService.addHome(home);
    }

    @Test
    public void testGetHome() {
        System.out.println("=============>");
        System.out.println(homeService.getHomeById("e96e834db53f4cf496404c0eb5f9ce4b"));
    }
    @Test
    public void testUpdateName(){
        homeService.updateNameById("e96e834db53f4cf496404c0eb5f9ce4b","修改后的名称22");
    }
}
