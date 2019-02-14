package com.luxoft.korzch.services;

import com.luxoft.korzch.domain.Order;

import java.util.List;

public interface OrderService {
    /**
     * todo add documentation
     * */
    List<Order> getClientOrders(String clientId);

    /**
     * todo add documentation
     * */
    void addOrder(Order order, long clientId);
}
