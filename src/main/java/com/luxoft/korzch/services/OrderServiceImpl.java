package com.luxoft.korzch.services;

import com.luxoft.korzch.dao.base.OrderDao;
import com.luxoft.korzch.domain.Client;
import com.luxoft.korzch.domain.Order;
import com.luxoft.korzch.services.base.OrderService;
import com.luxoft.korzch.services.base.Service;
import com.luxoft.korzch.services.base.SessionService;

import java.util.List;

public class OrderServiceImpl<T extends Order>
        extends Service<OrderDao<T>, T>
        implements OrderService<T> {

    private final SessionService sessionService;

    public OrderServiceImpl(SessionService sessionService, OrderDao<T> orderDao) {
        dao = orderDao;
        this.sessionService = sessionService;
    }

    @Override
    public List<T> getClientOrders(long id) {
        return dao.getByClientId(id);
    }

    @Override
    public boolean addOrder(T order) {
        Client client = sessionService.getCurrentClient();
        order.setClientId(client.getId());
        dao.create(order);
        return true;
    }
}
