package com.luxoft.korzch.dao.base;

import com.luxoft.korzch.domain.Product;

public interface ProductDao<T extends Product> extends CRUD<T>, Common<T> {

}
