package com.igood.smarthome.rpc.product.entity;

import com.igood.common.entity.DataEntity;

/**
 * 功能实体类
 *
 * @author linzhuowei
 * @create 2017/6/6
 */
public class Function extends DataEntity<Function> {
    private String productTypeId;//产品类型表ID
    private String name;//功能名称
    private int compCode;//程序代码里用于比较的code
    private String description;//功能详细解释

    private Boolean support;//自己添加的

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

    public int getCompCode() {
        return compCode;
    }

    public void setCompCode(int compCode) {
        this.compCode = compCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getSupport() {
        return support;
    }

    public void setSupport(Boolean support) {
        this.support = support;
    }
}
