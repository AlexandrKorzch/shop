package com.luxoft.korzch.dao.base;

import com.luxoft.korzch.base.Common;

import java.util.List;

public interface OrderDao<T> extends Common<T> {

    /**
     * TODO add documentation
     * */
    List<T> getByClientId(long id);
}
