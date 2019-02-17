package com.luxoft.korzch.services.base;

import com.luxoft.korzch.base.Common;
import com.luxoft.korzch.dao.base.Dao;

import java.util.ArrayList;

public abstract class Service<T> implements Common<T> {

    protected Dao<T> dao;

    @Override
    public T get(long id) {
        return dao.get(id);
    }

    @Override
    public long create(T item) {
        return dao.create(item);
    }

    @Override
    public long update(T item) {
        return dao.update(item);
    }

    @Override
    public long delete(T item) {
        return dao.delete(item);
    }

    @Override
    public ArrayList<T> getAll() {
        return null;
    }

    protected void setCommonDao(Common<T> dao) {
        this.dao = (Dao<T>) dao;
    }
}
