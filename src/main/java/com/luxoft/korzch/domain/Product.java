package com.luxoft.korzch.domain;

public class Product extends Model{

    private String name;
    private double price;

    public Product(String productName, double productPrice) {
        this.name = productName;
        this.price = productPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}