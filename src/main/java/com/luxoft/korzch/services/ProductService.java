package com.luxoft.korzch.services;

import com.luxoft.korzch.domain.Product;

import java.util.List;

public interface ProductService {

    /**
     * todo add documentation
     * */
    boolean addNewProduct(String productName, String productPrice);

    /**
     * todo add documentation
     * */
    boolean removeProduct(String productId);

    /**
     * todo add documentation
     * */
    List<Product> getAllProducts();
}

