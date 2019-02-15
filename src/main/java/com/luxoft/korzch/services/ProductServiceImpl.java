package com.luxoft.korzch.services;

import com.luxoft.korzch.dao.ProductDao;
import com.luxoft.korzch.dao.ProductDaoImpl;
import com.luxoft.korzch.domain.Product;

import java.util.List;

import static com.luxoft.korzch.util.Util.priceToFloat;

public class ProductServiceImpl implements ProductService {

    private final ProductDao productDao;

    public ProductServiceImpl() {
        this.productDao = ProductDaoImpl.getInstance();
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
