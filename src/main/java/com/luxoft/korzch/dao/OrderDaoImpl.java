package com.luxoft.korzch.dao;

import com.luxoft.korzch.dao.base.Dao;
import com.luxoft.korzch.dao.base.OrderDao;
import com.luxoft.korzch.domain.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl<T extends Order> extends Dao<T> implements OrderDao<T> {

    @Override
    public List<T> getByClientId(long id) {
        List<T> orders = new ArrayList<>();
        items.forEach((orderId, order) -> {
            if(order.getClientId() == id){
                orders.add(order);
            }
        });
        return orders;
    }
}
