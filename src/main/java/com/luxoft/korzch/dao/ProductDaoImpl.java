package com.luxoft.korzch.dao;

import com.luxoft.korzch.dao.base.Dao;
import com.luxoft.korzch.dao.base.ProductDao;
import com.luxoft.korzch.domain.Product;

public class ProductDaoImpl<T extends Product> extends Dao<T> implements ProductDao<T> {

}
