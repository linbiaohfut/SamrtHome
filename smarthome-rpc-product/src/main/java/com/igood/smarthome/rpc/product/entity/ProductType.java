package com.igood.smarthome.rpc.product.entity;

import com.igood.common.entity.DataEntity;

/**
 * 产品类型实体类
 *
 * @author linzhuowei
 * @create 2017/6/6
 */
public class ProductType extends DataEntity<ProductType> {
    private String name;
    private String description;
    private Integer compCode;

    public ProductType() {
    }

    public ProductType(String id) {
        super.id = id;
    }

    public ProductType(String id,String name) {
        super.id = id;
        this.name = name;
    }

    public ProductType(String id,String name, int compCode) {
        super.id = id;
        this.name = name;
        this.compCode = compCode;
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCompCode() {
        return compCode;
    }

    public void setCompCode(Integer compCode) {
        this.compCode = compCode;
    }
}
