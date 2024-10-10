package com.kevinpina.client;

import com.kevinpina.models.Product;
import com.kevinpina.services.ServiceEJBRemote;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Main {
    public static void main(String[] args) {

        ServiceEJBRemote serviceEJBRemote = null;

        // Move to src/main/resources/jndi.properties this files is load and read by the InitialContext.class
//        final Properties env = new Properties();
//        env.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
//        env.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
//        env.put("jboss.naming.client.ejb.context", true);
        try {
            //InitialContext ctx = new InitialContext(env);
            InitialContext ctx = new InitialContext();
            serviceEJBRemote = (ServiceEJBRemote) ctx.lookup("ejb:/app-ejb/ServiceEJBRemoteImpl!com.kevinpina.services.ServiceEJBRemote");
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }

        System.out.println(serviceEJBRemote.greetings("ludwig"));
        System.out.println(serviceEJBRemote.greetings("wolfgang"));

        Product product = serviceEJBRemote.addProduct(new Product("alarm"));
        System.out.println("New Product " + product);

        serviceEJBRemote.listProduct().forEach(System.out::println);
    }
}