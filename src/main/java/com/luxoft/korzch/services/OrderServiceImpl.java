package com.luxoft.korzch.services;

import com.luxoft.korzch.dao.OrderDao;
import com.luxoft.korzch.domain.Order;
import com.luxoft.korzch.session.Session;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private final OrderDao orderDao;
    private final SessionService sessionService;

    public OrderServiceImpl(OrderDao orderDao, SessionService sessionService) {
        this.orderDao = orderDao;
        this.sessionService = sessionService;
    }

    @Override
    public List<Order> getClientOrders(String clientId) {
        return null;
    }

    @Override
    public void addOrder(Order order, long clientId) {

    }
}
