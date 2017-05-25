package com.igood.smarthome.service.message.dao;

import com.igood.smarthome.common.core.dao.BaseDaoMapper;
import com.igood.smarthome.rpc.message.entity.SmsHistory;

/**
 * Created by Administrator on 2017/4/22.
 */
public interface SmsHistoryDaoMapper  extends BaseDaoMapper<SmsHistory> {
    /**
     * 当天发送的短信个数
     * @param smsHistory
     * @return
     */
    int loadOneDayCount(SmsHistory smsHistory);
    /**
     * 当前IP发送的短信个数
     * @param smsHistory
     * @return
     */
    int loadCurrentIpCount(SmsHistory smsHistory);

    /**
     * 获取最近的一条记录
     * @param smsHistory
     * @return
     */
    SmsHistory loadNewByPhoneAndType(SmsHistory smsHistory);
}
