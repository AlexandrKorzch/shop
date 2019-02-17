package com.luxoft.korzch.services.base;

import com.luxoft.korzch.base.Common;
import com.luxoft.korzch.domain.Model;

import java.util.ArrayList;

public abstract class Service<D extends Common<T>, T extends Model> implements Common<T> {

    protected D dao;

    @Override
    public T get(long id) {
        return dao.get(id);
    }

    @Override
    public long create(T item) {
        return dao.create(item);
    }

    @Override
    public boolean update(T item) {
        return dao.update(item);
    }

    @Override
    public boolean delete(long id) {
        return dao.delete(id);
    }

    @Override
    public ArrayList<T> getAll() {
        return dao.getAll();
    }
}
