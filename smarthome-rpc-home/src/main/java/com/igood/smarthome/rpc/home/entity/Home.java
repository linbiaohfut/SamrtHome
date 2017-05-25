package com.igood.smarthome.rpc.home.entity;

import com.igood.common.entity.DataEntity;

/**
 * 家庭信息
 *
 * @author linzhuowei
 * @create 2017/5/22
 */
public class Home extends DataEntity<Home> {
    private String name;
    private String picture;

    public Home() {
    }

    public Home(String id) {
        super.id = id;
    }

    public Home(String id,String name) {
        super.id = id;
        this.name = name;
    }

    public Home(String id,String name, String picture) {
        super.id = id;
        this.name = name;
        this.picture = picture;
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

    @Override
    public String toString() {
        return "Home{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", picture='" + picture + '\'' +
                ", remarks='" + remarks + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", status=" + status +

                '}';
    }
}
