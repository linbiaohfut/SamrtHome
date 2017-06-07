package com.igood.smarthome.rpc.product.entity;

import com.igood.common.entity.DataEntity;

/**
 * 产品实体类
 *
 * @author linzhuowei
 * @create 2017/6/6
 */
public class Product extends DataEntity<Product> {
    private String productTypeId;//产品类型表ID
    private String name;//产品备注名
    private String number;//产品编号
    private String description;
    public Product(String id) {
        this.id = id;
    }

    public Product(String productTypeId, String number) {
        this.productTypeId = productTypeId;
        this.number = number;
    }

    public Product(String id,String productTypeId, String number) {
        this(productTypeId, number);
        this.id = id;
    }

    public String getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(String productTypeId) {
        this.productTypeId = productTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
