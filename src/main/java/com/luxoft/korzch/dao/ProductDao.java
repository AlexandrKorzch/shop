package com.luxoft.korzch.dao;

import com.luxoft.korzch.domain.Product;

import java.util.List;

public interface ProductDao {

    /**
     * todo add documentation
     * */
    void addNewProduct(Product product);

    /**
     * todo add documentation
     * */
    void removeProduct(String productId);

    /**
     * todo add documentation
     * */
    List<Product> getAllProducts();

    /**
     * todo add documentation
     * */
    Product getProduct(long productId);
}
