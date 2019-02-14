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
}
