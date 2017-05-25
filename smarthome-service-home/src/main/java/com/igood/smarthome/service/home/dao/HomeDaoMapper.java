package com.igood.smarthome.service.home.dao;

import com.igood.smarthome.common.core.dao.BaseDaoMapper;
import com.igood.smarthome.rpc.home.entity.Home;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/4/22.
 */
@Repository
public interface HomeDaoMapper extends BaseDaoMapper<Home> {
    List<Home> getByUserId(String userId);
}
