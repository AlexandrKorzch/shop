package com.luxoft.korzch.services;

import com.luxoft.korzch.dao.ProductDao;
import com.luxoft.korzch.domain.Product;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private final ProductDao productDao;

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public boolean addNewProduct(String productName, String productPrice) {
        return false;
    }

    @Override
    public boolean removeProduct(String productId) {
        return false;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }
}
