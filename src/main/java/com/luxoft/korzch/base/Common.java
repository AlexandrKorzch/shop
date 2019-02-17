package com.luxoft.korzch.base;

import java.util.ArrayList;

public interface Common<T> extends CRUD<T> {

    /**
     * TODO add documentation
     */
    ArrayList<T> getAll();
}
