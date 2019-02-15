package com.luxoft.korzch.dao;

import com.luxoft.korzch.domain.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {

    private List<Order> orders = new ArrayList<>();

    private static final OrderDao instance = new OrderDaoImpl();

    private OrderDaoImpl(){}

    public static OrderDao getInstance(){
        return instance;
    }


    @Override
    public void addOrder(Order order) {
        orders.add(order);
    }
}
