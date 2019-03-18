package com.luxoft.korzch.services.jdbc;

import com.luxoft.korzch.database.dao.base.ProductDao;
import com.luxoft.korzch.domain.Product;
import com.luxoft.korzch.services.ProductService;

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
    public boolean create(Product item) {
        return productDao.create(item);
    }

    @Override
    public boolean update(Product product) {
        return productDao.update(product);
    }

    @Override
    public boolean delete(long id) {
        return productDao.delete(id);
    }
}
