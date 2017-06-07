package com.igood.smarthome.rpc.product.service;


import com.github.pagehelper.Page;
import com.igood.smarthome.rpc.product.entity.Function;

import java.util.List;

/**
 * 功能接口
 *
 * @author linzhuowei
 * @create 2017/6/6
 */
public interface RpcFunctionService {


    /**
     *  添加功能信息
     * @param function
     * @return 插入的行数
     */
    int addFunction(Function function);

    /**
     *  修改功能信息
     * @param function
     * @return 插入的行数
     */
    int updateFunction(Function function);

    /**
     *  根据ID删除功能信息
     * @param id
     * @return 插入的行数
     */
    int deleteFunction(String id);

    /**
     * 获取全部的功能信息(带分页)
     * @param pageNum 第几页
     * @param pageSize 每页大小
     * @return
     */
    Page<Function> getFunctions(int pageNum, int pageSize);

    /**
     * 根据功能类型ID获取全部的功能信息(带分页)
     * @param pageNum 第几页
     * @param pageSize 每页大小
     * @return
     */
    Page<Function> getFunctionsByType(String productTypeId,int pageNum, int pageSize);

    /**
     * 获取全部的功能信息(不带分页)
     * @return
     */
    List<Function> getFunctions();

    /**
     * 根据功能类型ID获取全部的功能信息(不带分页)
     * @return
     */
    List<Function> getFunctionsByType(String productTypeId);

}
