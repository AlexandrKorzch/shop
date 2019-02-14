package com.luxoft.korzch.services;

public interface ProductService {
    boolean addNewProduct(String productName, String productPrice);

    boolean removeProduct(String productId);
}

