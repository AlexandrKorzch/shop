package com.luxoft.korzch.services;

import com.luxoft.korzch.dao.base.ProductDao;
import com.luxoft.korzch.domain.Product;
import com.luxoft.korzch.services.base.ProductService;
import com.luxoft.korzch.services.base.Service;

public class ProductServiceImpl<T extends Product> extends Service<T> implements ProductService<T> {

    private final ProductDao<T> productDao;

    public ProductServiceImpl(ProductDao<T> productDao) {
        setCommonDao(productDao);
        this.productDao = productDao;
    }

//    @Override
//    public boolean addNewProduct(String productName, String productPrice) {
//        productDao.create(new Product(productName, priceToFloat(productPrice)));
//        return true;
//    }
//
//    @Override
//    public boolean removeProduct(String productId) {
//        productDao.removeProduct(productId);
//        return true;
//    }
//
//    @Override
//    public List<Product> getAllProducts() {
//        return productDao.getAllProducts();
//    }
}
