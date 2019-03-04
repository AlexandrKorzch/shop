package com.luxoft.korzch.database.dao.base;

import com.luxoft.korzch.domain.Product;

import java.util.List;

public interface BasketDao {

    /**
     * TODO add documentation
     */
    void add(long productId);

    /**
     * TODO add documentation
     */
    void remove(long productId);

    /**
     * TODO add documentation
     */
    List<Product> getAll();

    /**
     * TODO add documentation
     */
     void addAll(List<Product> products);



}