package com.luxoft.korzch.database.dao;

import com.luxoft.korzch.database.dao.base.BasketDao;
import com.luxoft.korzch.domain.Basket;

import java.sql.Connection;
import java.util.List;

public class BasketDaoImpl<T extends Basket> implements BasketDao<T> {

    private final Connection connection;

    public BasketDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(T item) {

    }

    @Override
    public T get(long id) {
        return null;
    }

    @Override
    public List<T> getAll() {
        return null;
    }

    @Override
    public void update(T item) {

    }

    @Override
    public void delete(long id) {

    }
}