package com.luxoft.korzch.base;

import java.util.List;

public interface Common<T> extends CRUD<T> {

    /**
     * TODO add documentation
     */
    List<T> getAll();
}
