package com.luxoft.korzch.base;

public interface CRUD<T> {

    /**
     * TODO add documentation
     */
    T get(long id);

    /**
     * TODO add documentation
     */
    boolean create(T item);

    /**
     * TODO add documentation
     */
    boolean update(T item);

    /**
     * TODO add documentation
     */
    boolean delete(long id);

}
