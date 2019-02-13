package com.luxoft.korzch.services;

import com.luxoft.korzch.dao.OrderDao;
import com.luxoft.korzch.session.Session;

public class OrderServiceImpl implements OrderService {

    private final OrderDao orderDao;
    private final SessionService sessionService;

    public OrderServiceImpl(OrderDao orderDao, SessionService sessionService) {
        this.orderDao = orderDao;
        this.sessionService = sessionService;
    }
}
