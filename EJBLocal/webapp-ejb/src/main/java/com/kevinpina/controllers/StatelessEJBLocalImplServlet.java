package com.kevinpina.controllers;

import com.kevinpina.models.Product;
import com.kevinpina.services.ServiceEJBLocal;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;

@WebServlet("/ejb_local")
public class StatelessEJBLocalImplServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServiceEJBLocal serviceEJBLocal;
        try {
            // Using JNDI
            InitialContext ctx = new InitialContext();
            // lookup("java:global/nameWar/nameEJBClass!packageEJBInterfaceLocalOrRemote.nameEJBInterface"); // With Local or Remote Interface
            // lookup("java:global/nameWar/nameEJBClass!packageEJBClass.nameEJBClass"); // Without interface
            serviceEJBLocal = (ServiceEJBLocal) ctx.lookup("java:global/webapp-ejb/ServiceEJBLocalImpl!com.kevinpina.services.ServiceEJBLocal");
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }

        Product product = new Product("ring bell");
        System.out.println(serviceEJBLocal.addProduct(product));

        req.setAttribute("greeting", serviceEJBLocal.greetings("pina"));
        req.setAttribute("list", serviceEJBLocal.listProduct());

        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }

}
