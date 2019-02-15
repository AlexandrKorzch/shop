package com.luxoft.korzch.services;

import com.luxoft.korzch.dao.OrderDao;
import com.luxoft.korzch.dao.OrderDaoImpl;
import com.luxoft.korzch.domain.Client;
import com.luxoft.korzch.domain.Order;

import java.util.List;

import static com.luxoft.korzch.util.Util.isNotNull;

public class OrderServiceImpl implements OrderService {

    private final OrderDao orderDao;
    private final SessionService sessionService;

    public OrderServiceImpl(SessionService sessionService) {
        this.orderDao = OrderDaoImpl.getInstance();
        this.sessionService = sessionService;
    }

    @Override
    public List<Order> getClientOrders(long clientId) {
        Client client = sessionService.getCurrentClient();
        if(isNotNull(client)){
            return client.getOrders();
        }else {
            return null;
        }
    }

    @Override
    public void addOrder(Order order, long clientId) {
        order.setClientId(clientId);
        orderDao.addOrder(order);
    }
}
