package com.luxoft.korzch.database.dao.base;

import com.luxoft.korzch.domain.Product;

import java.util.List;

public interface BasketDao {

    /**
     * TODO add documentation
     */
    boolean add(long productId, long clientId);

    /**
     * TODO add documentation
     */
    boolean remove(long productId, long clientId);

    /**
     * TODO add documentation
     */
    List<Product> getAll(long clientId);
}