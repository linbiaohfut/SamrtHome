package com.igood.smarthome.service.device.service;

import com.igood.smarthome.common.model.Page;
import com.igood.smarthome.rpc.device.entity.Device;
import com.igood.smarthome.rpc.device.entity.LockPassword;
import com.igood.smarthome.rpc.device.enums.DeviceType;
import com.igood.smarthome.rpc.device.enums.PasswordType;
import com.igood.smarthome.rpc.device.service.RpcLockService;
import org.springframework.stereotype.Service;

/**
 * 智能门锁服务
 *
 * @author linzhuowei
 * @create 2017/5/27
 */
@Service("lockService")
public class LockService  extends DeviceService implements RpcLockService{
    @Override
    public Page<LockPassword> getPasswordsByType(PasswordType passwordType, int pageNum, int pageSize) {
        return null;
    }

    @Override
    public LockPassword getLockPasswordById(String pwdId) {
        return null;
    }

    @Override
    public int addLockPassword(LockPassword password) {
        return 0;
    }

    @Override
    public int updatePasswordNameById(String pwdId, String name) {
        return 0;
    }

    @Override
    public int updatePasswordContentById(String pwdId, String content) {
        return 0;
    }

    @Override
    public void deletePasswordById(String id) {

    }
}
