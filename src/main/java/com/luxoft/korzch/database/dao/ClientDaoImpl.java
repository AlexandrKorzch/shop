package com.luxoft.korzch.database.dao;

import com.luxoft.korzch.database.dao.base.ClientDao;
import com.luxoft.korzch.domain.Client;

import java.sql.Connection;
import java.util.List;

public class ClientDaoImpl<T extends Client> implements ClientDao<T> {

    private final Connection connection;

    public ClientDaoImpl(Connection connection) {
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