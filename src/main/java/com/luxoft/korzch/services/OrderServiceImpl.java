package com.luxoft.korzch.services;

import com.luxoft.korzch.database.dao.base.OrderDao;
import com.luxoft.korzch.domain.Order;
import com.luxoft.korzch.services.base.OrderService;
import com.luxoft.korzch.services.base.SessionService;

import java.util.List;

public class OrderServiceImpl implements OrderService<Order> {

    private final OrderDao<Order> orderDao;
    private final SessionService sessionService;

    public OrderServiceImpl(OrderDao<Order> orderDao, SessionService sessionService) {
        this.orderDao = orderDao;
        this.sessionService = sessionService;
    }

    @Override
    public boolean create(Order order) {
        return orderDao.create(order);
    }

    @Override
    public Order get(long id) {
        return orderDao.get(id);
    }

    @Override
    public boolean update(Order order) {
        return orderDao.update(order);
    }

    @Override
    public List<Order> getClientOrders(long clientId) {
        return orderDao.getAllClientOrders(clientId);
    }

    @Override
    public boolean delete(long id) {
        return orderDao.delete(id);
    }

    @Override
    public boolean addOrder(Order order) {
        return orderDao.create(order);
    }

    @Override
    public List<Order> getAll() {
        return orderDao.getAll();
    }
}
