package com.luxoft.korzch.services;

import com.luxoft.korzch.dao.base.ProductDao;
import com.luxoft.korzch.domain.Product;

import java.util.List;

import static com.luxoft.korzch.util.Util.priceToFloat;

public class ProductServiceImpl implements ProductService {

    private final ProductDao productDao;

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public boolean addNewProduct(String productName, String productPrice) {
        productDao.addNewProduct(new Product(productName, priceToFloat(productPrice)));
        return true;
    }

    @Override
    public boolean removeProduct(String productId) {
        productDao.removeProduct(productId);
        return true;
    }

    @Override
    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }
}
