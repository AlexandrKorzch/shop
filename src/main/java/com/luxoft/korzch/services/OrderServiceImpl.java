package com.luxoft.korzch.services;

import com.luxoft.korzch.database.dao.base.OrderDao;
import com.luxoft.korzch.domain.Order;
import com.luxoft.korzch.services.base.OrderService;

import java.util.List;

public class OrderServiceImpl<T extends Order> implements OrderService<T> {

    private final OrderDao<T> orderDao;

    public OrderServiceImpl(OrderDao<T> orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public List<T> getClientOrders() {
        return null;
    }

    @Override
    public boolean addOrder(T order) {
        return false;
    }

    @Override
    public List<T> getAll() {
        return null;
    }

    @Override
    public T get(long id) {
        return null;
    }

    @Override
    public void create(T item) {

    }

    @Override
    public void update(T item) {

    }

    @Override
    public void delete(long id) {

    }

//    private final SessionService sessionService;
//
//    public OrderServiceImpl(SessionService sessionService, OrderDao<T> orderDao) {
//        dao = orderDao;
//        this.sessionService = sessionService;
//    }
//
//    @Override
//    public List<T> getClientOrders() {
//        Client client = sessionService.getCurrentClient();
//        long clientId = client.getId();
//        return dao.getByClientId(clientId);
//    }
//
//    @Override
//    public boolean addOrder(T order) {
//        Client client = sessionService.getCurrentClient();
//        order.setClientId(client.getId());
//        dao.create(order);
//        return true;
//    }
}
