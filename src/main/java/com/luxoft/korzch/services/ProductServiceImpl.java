package com.luxoft.korzch.services;

import com.luxoft.korzch.dao.base.ProductDao;
import com.luxoft.korzch.domain.Product;
import com.luxoft.korzch.services.base.ProductService;
import com.luxoft.korzch.services.base.Service;

public class ProductServiceImpl<T extends Product>
        extends Service<ProductDao<T>, T>
        implements ProductService<T> {

    public ProductServiceImpl(ProductDao<T> productDao) {
        dao = productDao;
    }
}
