package com.igood.smarthome.service.product.dao;

import com.igood.smarthome.common.core.dao.BaseDaoMapper;
import com.igood.smarthome.common.model.Page;
import com.igood.smarthome.rpc.product.entity.Function;
import com.igood.smarthome.rpc.product.entity.Product;

import java.util.List;

/**
 * Created by Administrator on 2017/6/7.
 */
public interface ProductDaoMapper  extends BaseDaoMapper<Product> {


    Page<Product> getProductsByType(String productTypeId, int pageNum, int pageSize);


    List<Function> getProductFunctions(String productId);
}
