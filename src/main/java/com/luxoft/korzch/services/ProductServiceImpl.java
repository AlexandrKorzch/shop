package com.luxoft.korzch.services;

import com.luxoft.korzch.dao.ProductDao;

public class ProductServiceImpl implements ProductService {

    private final ProductDao productDao;

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }
}
