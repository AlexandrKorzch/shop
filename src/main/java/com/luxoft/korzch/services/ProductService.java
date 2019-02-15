package com.luxoft.korzch.services;

import com.luxoft.korzch.domain.Product;

import java.util.List;

public interface ProductService {

    /**
     * TODO add documentation
     * */
    boolean addNewProduct(String productName, String productPrice);

    /**
     * TODO add documentation
     * */
    boolean removeProduct(String productId);

    /**
     * TODO add documentation
     * */
    List<Product> getAllProducts();
}

