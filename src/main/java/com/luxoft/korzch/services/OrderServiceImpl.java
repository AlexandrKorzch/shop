package com.luxoft.korzch.services;

import com.luxoft.korzch.dao.base.OrderDao;
import com.luxoft.korzch.domain.Order;
import com.luxoft.korzch.services.base.OrderService;
import com.luxoft.korzch.services.base.Service;
import com.luxoft.korzch.services.base.SessionService;

import java.util.List;

public class OrderServiceImpl<T extends Order> extends Service<T> implements OrderService<T> {

    private final OrderDao orderDao;
    private final SessionService sessionService;

    public OrderServiceImpl(SessionService sessionService, OrderDao<T> orderDao) {
        setCommonDao(orderDao);
        this.orderDao  = orderDao;
        this.sessionService = sessionService;
    }

    @Override
    public List<T> getClientOrders(long id) {
        return null;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public long addOrder(Order order, long clientId) {
        return 0;
    }

    //    @Override
//    public List<Order> getClientOrders(long clientId) {
//        Client client = sessionService.getCurrentClient();
//        if(isNotNull(client)){
//            return client.getOrders();
//        }else {
//            return null;
//        }
//    }
//
//    @Override
//    public void addOrder(Order order, long clientId) {
//        order.setClientId(clientId);
//        orderDao.addOrder(order);
//    }
}
