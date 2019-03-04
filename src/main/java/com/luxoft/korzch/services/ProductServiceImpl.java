package com.luxoft.korzch.services;

import com.luxoft.korzch.database.dao.base.ProductDao;
import com.luxoft.korzch.domain.Product;
import com.luxoft.korzch.services.base.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService<Product> {

    private final ProductDao<Product> productDao;

    public ProductServiceImpl(ProductDao<Product> productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }

    @Override
    public Product get(long id) {
        return productDao.get(id);
    }

    @Override
    public void create(Product item) {
        productDao.create(item);
    }

    @Override
    public void update(Product item) {
        productDao.update(item);
    }

    @Override
    public void delete(long id) {
        productDao.delete(id);
    }
}
