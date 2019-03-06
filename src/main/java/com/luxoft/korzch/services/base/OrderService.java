package com.luxoft.korzch.services.base;

import com.luxoft.korzch.base.Common;
import com.luxoft.korzch.domain.Order;

import java.util.List;

public interface OrderService<T extends Order> extends Common<T> {

    /**
     * TODO add documentation
     * */
    List<T> getClientOrders(long clientId);

    /**
     * TODO add documentation
     * */
    boolean addOrder(T order);
}
