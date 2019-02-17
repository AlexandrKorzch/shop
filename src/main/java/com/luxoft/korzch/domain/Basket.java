package com.luxoft.korzch.domain;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private long id;
    private List<Product> items = new ArrayList<>();

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public List<Product> getItems() {
        return items;
    }

    public void setItems(List<Product> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "id=" + id +
                ", items=" + items +
                '}';
    }
}
