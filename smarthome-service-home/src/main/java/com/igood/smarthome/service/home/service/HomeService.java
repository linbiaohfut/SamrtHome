package com.igood.smarthome.service.home.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.igood.common.entity.enums.Status;
import com.igood.smarthome.rpc.home.entity.Home;
import com.igood.smarthome.rpc.home.service.RpcHomeService;
import com.igood.smarthome.service.home.dao.HomeDaoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 家庭服务实现类
 *
 * @author linzhuowei
 * @create 2017/4/22
 */
@Service("homeService")
public class HomeService implements RpcHomeService {
    @Autowired
    private HomeDaoMapper homeDao;
    @Override
    public Home getHomeById(String id) {
        return homeDao.load(new Home(id));
    }

    /**
     *
     * @param userId 用户ID
     * @param pageNum 第几页
     * @param pageSize 每页大小
     * @return
     */
    @Override
    public PageInfo<Home> getHomesByUserId(String userId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Home> homes = homeDao.getByUserId(userId);
        PageInfo<Home> HomePageInfo = new PageInfo<>(homes);
        return HomePageInfo;
    }

    @Override
    public int updateNameById(String id, String name) {
        return homeDao.update(new Home(id,name));
    }

    @Override
    public int updatePictureById(String id, String picturePath) {
        Home home = new Home(id);
        home.setPicture(picturePath);
        return homeDao.update(home);
    }

    @Override
    public void deleteHomeById(String id) {
        Home home = new Home(id);
        home.setStatus(Status.DELETE);
        homeDao.update(home);
    }

    @Override
    public int addHome(Home home) {
        home.preInsert();
        return homeDao.save(home);
    }
}
