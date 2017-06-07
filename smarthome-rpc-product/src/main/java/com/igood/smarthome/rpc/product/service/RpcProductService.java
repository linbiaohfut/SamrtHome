package com.igood.smarthome.rpc.product.service;

import com.igood.smarthome.common.model.Page;
import com.igood.smarthome.rpc.product.entity.Function;
import com.igood.smarthome.rpc.product.entity.Product;
import com.igood.smarthome.rpc.product.entity.ProductType;

import java.util.List;

/**
 * Created by Administrator on 2017/6/6.
 */
public interface RpcProductService {

    /**
     *  添加产品类型信息
     * @param productType
     * @return 插入的行数
     */
    int addProductType(ProductType productType);

    /**
     * 根据ID获取产品类型信息
     * @param id
     * @return
     */
    ProductType getProductTypeById(String id);
    /**
     * 获取全部的产品类型信息
     * @param
     * @return
     */
    List<ProductType> getProductTypes();

    /**
     * 获取全部的产品类型信息(带分页)
     * @param pageNum 第几页
     * @param pageSize 每页大小
     * @return
     */
    Page<ProductType> getProductTypes(int pageNum, int pageSize);

    /**
     *  修改产品类型信息
     * @param productType
     * @return 插入的行数
     */
    int updateProductType(ProductType productType);

    /**
     *  根据ID删除产品类型信息
     * @param id
     * @return 插入的行数
     */
    int deleteProductType(String id);


    /**
     *  添加产品信息
     * @param product
     * @return 插入的行数
     */
    int addProduct(Product product);

    /**
     *  修改产品信息
     * @param product
     * @return 插入的行数
     */
    int updateProduct(Product product);

    /**
     *  根据ID删除产品信息
     * @param id
     * @return 插入的行数
     */
    int deleteProduct(String id);

    /**
     * 获取全部的产品信息(带分页)
     * @param pageNum 第几页
     * @param pageSize 每页大小
     * @return
     */
    Page<Product> getProducts(int pageNum, int pageSize);

    /**
     * 根据产品类型ID获取全部的产品信息(带分页)
     * @param pageNum 第几页
     * @param pageSize 每页大小
     * @return
     */
    Page<Product> getProductsByType(String productTypeId,int pageNum, int pageSize);

    /**
     * 根据产品ID获取该产品的功能集
     * @return
     */
    List<Function> getProductFunctions(String productId);
}
