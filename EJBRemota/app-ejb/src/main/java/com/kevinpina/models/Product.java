package com.kevinpina.models;

import java.io.Serializable;

public class Product implements Serializable {

    private String name;

    public Product() {
        super();
    }

    public Product(String name) {
        this.name = name;
    }

    public Product(Product product) {
        name = product.name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
