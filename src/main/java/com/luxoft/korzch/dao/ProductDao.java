package com.luxoft.korzch.dao;

import com.luxoft.korzch.domain.Product;

import java.util.List;

public interface ProductDao {

    /**
     * TODO add documentation
     * */
    void addNewProduct(Product product);

    /**
     * TODO add documentation
     * */
    void removeProduct(String productId);

    /**
     * TODO add documentation
     * */
    List<Product> getAllProducts();

    /**
     * TODO add documentation
     * */
    Product getProduct(long productId);
}
