package com.luxoft.korzch.database.dao;

import com.luxoft.korzch.database.dao.base.BasketDao;
import com.luxoft.korzch.domain.Product;

import java.sql.Connection;
import java.util.List;

public class BasketDaoImpl implements BasketDao {

    private final Connection connection;

    public BasketDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void add(long productId) {

    }

    @Override
    public List<Product> getAll() {
        return null;
    }

    @Override
    public void addAll(List<Product> products) {

    }

    @Override
    public void remove(long productId) {

    }
}