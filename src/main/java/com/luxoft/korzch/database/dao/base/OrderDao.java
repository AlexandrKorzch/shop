package com.luxoft.korzch.database.dao.base;

import com.luxoft.korzch.base.Common;

import java.util.List;

public interface OrderDao<T> extends Common<T> {

    /**
     * TODO add documentation
     * */
    List<T> getAllClientOrders(long id);
}
