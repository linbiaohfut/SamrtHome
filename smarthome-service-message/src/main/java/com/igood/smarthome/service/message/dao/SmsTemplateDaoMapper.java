package com.igood.smarthome.service.message.dao;

import com.igood.smarthome.common.core.dao.BaseDaoMapper;
import com.igood.smarthome.rpc.message.entity.SmsTemplate;

/**
 * Created by Administrator on 2017/4/22.
 */
public interface SmsTemplateDaoMapper extends BaseDaoMapper<SmsTemplate> {
    /**
     * 获取正在使用的模板
     * @return
     */
    SmsTemplate loadRegTemp();

}