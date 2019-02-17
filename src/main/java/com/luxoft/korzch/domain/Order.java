package com.luxoft.korzch.domain;

import java.util.List;

public class Order extends Model{

    private long clientId;
    private List<Product> products;

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + getId() +
                ", clientId=" + clientId +
                ", products=" + products +
                '}';
    }
}