package com.luxoft.korzch.domain;

import java.util.ArrayList;
import java.util.List;

public class Basket extends Model{

    private List<Product> items = new ArrayList<>();

    public List<Product> getItems() {
        return items;
    }

    public void setItems(List<Product> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "id=" + getId() +
                ", items=" + items +
                '}';
    }
}
