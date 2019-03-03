package com.luxoft.korzch.services;

import com.luxoft.korzch.database.dao.base.ProductDao;
import com.luxoft.korzch.domain.Product;
import com.luxoft.korzch.services.base.ProductService;

import java.util.List;

public class ProductServiceImpl<T extends Product> implements ProductService<T> {

    private final ProductDao<T> productDao;

    public ProductServiceImpl(ProductDao<T> productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<T> getAll() {
        return null;
    }

    @Override
    public T get(long id) {
        return null;
    }

    @Override
    public void create(T item) {

    }

    @Override
    public void update(T item) {

    }

    @Override
    public void delete(long id) {

    }
}
