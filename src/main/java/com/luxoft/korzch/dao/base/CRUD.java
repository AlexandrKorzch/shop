package com.luxoft.korzch.dao.base;

public interface CRUD<T> {

    /**
     * TODO add documentation
     */
    T get(long id);

    /**
     * TODO add documentation
     */
    long create(T item);

    /**
     * TODO add documentation
     */
    long update(T item);

    /**
     * TODO add documentation
     */
    long delete(T item);

}
