package com.luxoft.korzch.base;

public interface CRUD<T> {

    /**
     * TODO add documentation
     */
    T get(long id);

    /**
     * TODO add documentation
     */
    void create(T item);

    /**
     * TODO add documentation
     */
    void update(T item);

    /**
     * TODO add documentation
     */
    void delete(long id);

}
