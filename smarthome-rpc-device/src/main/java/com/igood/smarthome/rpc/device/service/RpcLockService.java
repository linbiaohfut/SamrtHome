package com.igood.smarthome.rpc.device.service;

import com.igood.smarthome.common.model.Page;
import com.igood.smarthome.rpc.device.entity.LockPassword;
import com.igood.smarthome.rpc.device.enums.PasswordType;


/**
 * Created by Administrator on 2017/5/25.
 */
public interface RpcLockService extends RpcDeviceService{

    /**
     * 根据密码类型获取该类型所有密码列表
     * @return
     */
    Page<LockPassword> getPasswordsByType(PasswordType passwordType, int pageNum, int pageSize);

    /**
     * 根据ID获取密码信息
     * @param pwdId
     * @return
     */
    LockPassword getLockPasswordById(String pwdId);

    /**
     *  添加密码信息
     * @param password
     * @return 插入的行数
     */
    int addLockPassword(LockPassword password);

    /**
     * 更新密码备注名
     * @param pwdId
     * @return 如果影响的行数大于1，表示更新记录行数
     */
    int updatePasswordNameById(String pwdId, String name);
    /**
     * 更新密码值内容
     * @param pwdId
     * @return 如果影响的行数大于1，表示更新记录行数
     */
    int updatePasswordContentById(String pwdId, String content);

    /**
     * 根据ID删除密码
     * @param id
     */
    void deletePasswordById(String id);
}
