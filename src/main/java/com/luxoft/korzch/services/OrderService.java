package com.luxoft.korzch.services;

import com.luxoft.korzch.domain.Order;

import java.util.List;

public interface OrderService {
    List<Order> getClientOrders(String clientId);
}
