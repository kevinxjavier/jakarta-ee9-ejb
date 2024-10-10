package com.kevinpina.services;

import com.kevinpina.models.Product;
import jakarta.ejb.Remote;

import java.util.List;

// Local, this Interface is for use inside the same Application Server, no matter same project or different one.
// Remote, use to be invoked from outside the Application Server, another Tomcat, WebLogic or a main class. And must implements Serializable.
@Remote //could implements also @Local and vice versa
public interface ServiceEJBRemote {

    String greetings(String name);

    List<Product> listProduct();

    Product addProduct(Product product);

}
