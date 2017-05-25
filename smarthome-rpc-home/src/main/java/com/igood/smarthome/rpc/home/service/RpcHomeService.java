package com.igood.smarthome.rpc.home.service;

import com.github.pagehelper.PageInfo;
import com.igood.smarthome.rpc.home.entity.Home;

import java.util.List;

/**
 * 家庭服务接口
 * Created by Administrator on 2017/4/22.
 */
public interface RpcHomeService {
    /**
     *  添加家庭信息
     * @param home
     * @return 插入的行数
     */
    int addHome(Home home);
    /**
     * 根据ID获取家庭信息
     * @param id
     * @return
     */
    Home getHomeById(String id);

    /**
     * 根据用户ID获取他拥有的家庭
     * @param userId
     * @return
     */
    PageInfo<Home> getHomesByUserId(String userId, int pageNum, int pageSize);

    /**
     * 更新家庭名称
     * @param id
     * @return 如果影响的行数大于1，表示更新记录行数
     */
    int updateNameById(String id, String name);

    /**
     * 更新家庭图片
     * @param id
     * @return 如果影响的行数大于1，表示更新记录行数
     */
    int updatePictureById(String id,String picturePath);

    /**
     * 根据ID删除家庭
     * @param id
     */
    void deleteHomeById(String id);
}
