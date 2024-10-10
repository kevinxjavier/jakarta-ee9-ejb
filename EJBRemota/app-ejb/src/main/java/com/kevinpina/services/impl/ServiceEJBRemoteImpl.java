package com.kevinpina.services.impl;

import com.kevinpina.models.Product;
import com.kevinpina.services.ServiceEJBRemote;
import jakarta.ejb.Stateless;

import java.util.List;
import java.util.stream.Stream;

@Stateless // An EJB always manage by default transactionality
public class ServiceEJBRemoteImpl implements ServiceEJBRemote {

    @Override
    public String greetings(String name) {
        return "Hi " + name + ". Instance " + this;
    }

    @Override
    public List<Product> listProduct() {
        return Stream.of(
                new Product("window"),
                new Product("table"),
                new Product("door")).toList();
    }

    @Override
    public Product addProduct(Product product) {
        System.out.println("Saving product [" + product + "]");
        return new Product(product);
    }


}
