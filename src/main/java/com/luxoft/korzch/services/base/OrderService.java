package com.luxoft.korzch.services.base;

import com.luxoft.korzch.base.CRUD;
import com.luxoft.korzch.base.Common;
import com.luxoft.korzch.domain.Order;

import java.util.List;

public interface OrderService<T extends Order> extends Common<T> {

    List<T> getClientOrders(long id);


//    /**
//     * TODO add documentation
//     *
//     * @param clientId*/
//    List<Order> getClientOrders(long clientId);
//
//    /**
//     * TODO add documentation
//     * */
//    void addOrder(Order order, long clientId);
}
