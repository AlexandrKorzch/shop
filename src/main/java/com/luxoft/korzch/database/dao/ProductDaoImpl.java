package com.luxoft.korzch.database.dao;

import com.luxoft.korzch.database.dao.base.ProductDao;
import com.luxoft.korzch.domain.Product;

import java.sql.Connection;
import java.util.List;

public class ProductDaoImpl<T extends Product> implements ProductDao<T> {

    private final Connection connection;

    public ProductDaoImpl(Connection connection) {
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

//            Statement statement = connection.createStatement()) {
//            statement.executeQ("INSERT INTO client (name, age, phone, email) VALUES ('serey', 36, '+380683777456', 'aratndr@risnt.rst')");
}
