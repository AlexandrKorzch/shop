package com.luxoft.korzch.database.dao;

import com.luxoft.korzch.database.dao.base.OrderDao;
import com.luxoft.korzch.domain.Order;

import java.sql.Connection;
import java.util.List;

public class OrderDaoImpl<T extends Order> implements OrderDao<T> {

    private final Connection connection;

    public OrderDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(T item) {

    }

    @Override
    public T get(long id) {
        return null;
    }

    @Override
    public List<T> getAll() {
        return null;
    }

    @Override
    public void update(T item) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public List<T> getByClientId(long id) {
        return null;
    }


    //    @Override
//    public List<T> getByClientId(long id) {
//        List<T> orders = new ArrayList<>();
//        items.forEach((orderId, order) -> {
//            if(order.getClientId() == id){
//                orders.add(order);
//            }
//        });
//        return orders;
//    }
}