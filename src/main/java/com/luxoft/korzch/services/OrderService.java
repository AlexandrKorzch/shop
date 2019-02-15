package com.luxoft.korzch.services;

import com.luxoft.korzch.domain.Order;

import java.util.List;

public interface OrderService {
    /**
     * TODO add documentation
     *
     * @param clientId*/
    List<Order> getClientOrders(long clientId);

    /**
     * TODO add documentation
     * */
    void addOrder(Order order, long clientId);
}
