package com.luxoft.korzch.domain;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private long id;
    private long clientId;
    private List<Product> basket = new ArrayList<>();

    public List<Product> getBasket() {
        return basket;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public void setBasket(List<Product> basket) {
        this.basket = basket;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", basket=" + basket +
                '}';
    }
}
