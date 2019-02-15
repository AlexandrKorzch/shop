package com.luxoft.korzch.dao;

import com.luxoft.korzch.domain.Product;

import java.util.ArrayList;
import java.util.List;

import static com.luxoft.korzch.util.Util.idToLong;

public class ProductDaoImpl implements ProductDao {

    private List<Product> products = new ArrayList<>();

    private static final ProductDao instance = new ProductDaoImpl();

    private ProductDaoImpl(){}

    public static ProductDao getInstance(){
        return instance;
    }

    @Override
    public void addNewProduct(Product product) {
        products.add(product);
    }

    @Override
    public void removeProduct(String productId) {
        products.forEach(product -> {
            if (product.getId() == idToLong(productId)) {
                products.remove(product);
                return;
            }
        });
    }

    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    @Override
    public Product getProduct(long productId) {
        for (Product product : products) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null;
    }
}
