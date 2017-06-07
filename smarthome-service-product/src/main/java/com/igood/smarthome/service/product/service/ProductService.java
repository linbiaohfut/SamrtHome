package com.igood.smarthome.service.product.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.igood.common.entity.enums.Status;
import com.igood.smarthome.common.model.Page;
import com.igood.smarthome.rpc.product.entity.Function;
import com.igood.smarthome.rpc.product.entity.Product;
import com.igood.smarthome.rpc.product.entity.ProductType;
import com.igood.smarthome.rpc.product.service.RpcProductService;
import com.igood.smarthome.service.product.dao.ProductDaoMapper;
import com.igood.smarthome.service.product.dao.ProductTypeDaoMapper;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * 产品服务
 *
 * @author linzhuowei
 * @create 2017/6/6
 */
@Service("productService")
public class ProductService implements RpcProductService {
    @Autowired
    private ProductTypeDaoMapper productTypeDao;
    @Autowired
    private ProductDaoMapper productDao;
    @Override
    public int addProductType(ProductType productType) {
        productType.preInsert();
        return productTypeDao.save(productType);
    }

    @Override
    public ProductType getProductTypeById(String id) {
        return productTypeDao.load(new ProductType(id));
    }

    @Override
    public List<ProductType> getProductTypes() {
        return productTypeDao.loadAll();
    }

    @Override
    public Page<ProductType> getProductTypes(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<ProductType> productTypes = productTypeDao.loadAll();

        try {
            PageInfo<ProductType> productTypePageInfo = new PageInfo<>(productTypes);
            Page<ProductType> productTypePage = new Page<>();
            BeanUtils.copyProperties(productTypePage, productTypePageInfo);
            productTypePage.setList(productTypes);
            return productTypePage;
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int updateProductType(ProductType productType) {
        return productTypeDao.update(productType);
    }

    @Override
    public int deleteProductType(String id) {
        ProductType productType = new ProductType(id);
        productType.setStatus(Status.DELETE);

        return productTypeDao.update(productType);
    }

    @Override
    public int addProduct(Product product) {
        product.preInsert();
        return productDao.save(product);
    }

    @Override
    public int updateProduct(Product product) {
        return productDao.update(product);
    }

    @Override
    public int deleteProduct(String id) {
        Product product = new Product(id);
        product.setStatus(Status.DELETE);
        return productDao.update(product);
    }

    @Override
    public Page<Product> getProducts(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Product> products = productDao.loadAll();

        try {
            PageInfo<Product> productPageInfo = new PageInfo<>(products);
            Page<Product> productPage = new Page<>();
            BeanUtils.copyProperties(productPage, productPageInfo);
            productPage.setList(products);
            return productPage;
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Page<Product> getProductsByType(String productTypeId, int pageNum, int pageSize) {
        return null;
    }

    @Override
    public List<Function> getProductFunctions(String productId) {
        return null;
    }
}
