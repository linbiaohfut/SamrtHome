package com.igood.smarthome.service.message.service;

import com.igood.smarthome.common.security.CodecUtil;
import com.igood.smarthome.common.utils.StringUtils;
import com.igood.smarthome.rabbitmq.enums.MsgType;
import com.igood.smarthome.rabbitmq.model.SmsModel;
import com.igood.smarthome.rpc.message.entity.SmsHistory;
import com.igood.smarthome.rpc.message.entity.SmsTemplate;
import com.igood.smarthome.rpc.message.service.RpcSmsService;
import com.igood.smarthome.service.message.dao.SmsHistoryDaoMapper;
import com.igood.smarthome.service.message.dao.SmsTemplateDaoMapper;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * 短信服务-短信服务消费者
 * @author linzhuowei
 * @create 2017/4/22
 */
public class SmsService implements RpcSmsService {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SmsTemplateDaoMapper smsTemplateDao;
    @Autowired
    private SmsHistoryDaoMapper smsHistoryDao;

    @Override
    public int getCountByDay(String phone) {
        SmsHistory smsHistory = new SmsHistory();
        smsHistory.setPhone(phone);
        DateTime startOfDay = new DateTime().withTimeAtStartOfDay();
        smsHistory.setStartOfDay(new Date(startOfDay.getMillis()));
        return smsHistoryDao.loadOneDayCount(smsHistory);
    }
    @Override
    public int getCountByIp(String ip) {
        SmsHistory smsHistory = new SmsHistory();
        smsHistory.setUserIp(ip);
        DateTime startOfDay = new DateTime().withTimeAtStartOfDay();
        smsHistory.setStartOfDay(new Date(startOfDay.getMillis()));
        return smsHistoryDao.loadCurrentIpCount(smsHistory);
    }

    /**
     * 发送短信验证码
     * @param smsModel
     */
    @Override
    public void sendValidate(SmsModel smsModel) {

        int countByDay = getCountByDay(smsModel.getPhone());
        if (countByDay >= 4) {
            logger.warn("当前手机号"+smsModel.getPhone()+"发送次数太多");
            return;
        }
        int countByIp = getCountByIp(smsModel.getUserIp());
        if (countByIp >= 4) {
            logger.warn("当前IP"+smsModel.getUserIp()+"发送次数太多");
            return;
        }

        SmsTemplate validateTemplate = smsTemplateDao.load(new SmsTemplate(MsgType.VALIDATE));
        String code = CodecUtil.createRandomNum(4);
        String content = StringUtils.replace(StringUtils.replace(validateTemplate.getContent(), "[MSGCODE]", code),
                "[TIMEOUT]", validateTemplate.getTimeout()+"");

        // 发送短信 开始
        logger.info("开始发送短信===> "+content);

        // 保存短息历史纪录
        SmsHistory history = new SmsHistory();
        history.setPhone(smsModel.getPhone());
        history.setUserIp(smsModel.getUserIp());
        history.setContent(content);
        history.setSender("system");
        history.setTimeout(validateTemplate.getTimeout());
        history.setType(MsgType.VALIDATE);
        history.setValidate(code);
        history.preInsert();
        smsHistoryDao.save(history);
    }

    @Override
    public SmsHistory getInfoByPhoneAndType(String phone, MsgType type) {
        SmsHistory history = new SmsHistory();
        history.setPhone(phone);
        history.setType(type);
        return smsHistoryDao.loadNewByPhoneAndType(history);
    }

    /**
     * 发送短信通知
     * @param smsModel
     */
    @Override
    public void sendNotice(SmsModel smsModel) {
        logger.info("==================> "+smsModel);

        SmsTemplate cashConsumeTemplate = smsTemplateDao.load(new SmsTemplate(MsgType.NOTICE_CASH_COMSUME));
        String content = StringUtils.replace(StringUtils.replace(cashConsumeTemplate.getContent(), "[DATE]",
                DateTime.now().toString("MM月dd日HH时mm分")), "[AMOUNT]", smsModel.getContent());

        // 发送短信 开始
        logger.info("开始发送短信===> "+content);

        // 保存短息历史纪录
        SmsHistory history = new SmsHistory();
        history.setPhone(smsModel.getPhone());
        history.setUserIp(smsModel.getUserIp());
        history.setContent(content);
        history.setSender("system");
        history.setType(MsgType.NOTICE_CASH_COMSUME);
        history.preInsert();
        smsHistoryDao.save(history);
    }

    /**
     * 发送活动短信
     * @param msgData
     */
    @Override
    public void sendActivity(String msgData) {
        logger.info("==================> "+msgData);
    }
}

