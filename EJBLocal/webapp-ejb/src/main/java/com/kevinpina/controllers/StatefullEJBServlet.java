package com.kevinpina.controllers;

import com.kevinpina.services.impl.ServiceSatefullEJB;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/statefull")
public class StatefullEJBServlet extends HttpServlet {

    /*
        In Servlet is ok used @Stateless EJB, but it is not good for @Statefull because of
        the Servlet are static and singleton will treat the @Statefull EJB as a @Stateless.

        It is not good have @Stateless EJB with a context, e.g.; @Stateless @RequestScope class ...
        but @Statefull with context are ok, e.g.; @Statefull @RequestScope class ...
     */

    // This EJB is Local due to is used on the same project so no need of JNDI
    @EJB //@Inject // Also works always we have CDI activated as dependency
    private ServiceSatefullEJB serviceSatefullEJB1;

    @EJB
    private ServiceSatefullEJB serviceSatefullEJB2;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("Is serviceSatefullEJB1 equals to serviceSatefullEJB2 " + serviceSatefullEJB1.equals(serviceSatefullEJB2));
        // Will be false the condition above EJB are @Statefull, so they are not shared, and they have different hashCode()
        // but both will preserve the same hashCode and due to Servlet is static the count will increase
        // because of EJB behave as a @Stateless or static inside a Servlet.

        req.setAttribute("greeting", serviceSatefullEJB1.greetings("kevin"));
        req.setAttribute("greeting2", serviceSatefullEJB2.greetings("javier"));
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }

}
