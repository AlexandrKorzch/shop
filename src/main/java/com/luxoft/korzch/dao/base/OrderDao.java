package com.luxoft.korzch.dao.base;

import com.luxoft.korzch.domain.Order;

public interface OrderDao<T extends Order> extends CRUD<T>, Common<T> {


}
