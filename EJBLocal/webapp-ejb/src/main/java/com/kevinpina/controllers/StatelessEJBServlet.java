package com.kevinpina.controllers;

import com.kevinpina.services.impl.ServiceSatelessEJB;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/stateless")
public class StatelessEJBServlet extends HttpServlet {

    /*
        In Servlet is ok used @Stateless EJB, but it is not good for @Statefull because of
        the Servlet are static and singleton will treat the @Statefull EJB as a @Stateless.

        It is not good have @Stateless EJB with a context, e.g.; @Stateless @RequestScope class ...
        but @Statefull with context are ok, e.g.; @Statefull @RequestScope class ...
     */

    // This EJB is Local due to is used on the same project so no need of JNDI
    @EJB //@Inject // Also works always we have CDI activated as dependency
    private ServiceSatelessEJB serviceSatelessEJB1;

    @EJB
    private ServiceSatelessEJB serviceSatelessEJB2;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("Is serviceSatelessEJB1 equals to serviceSatelessEJB2 " + serviceSatelessEJB1.equals(serviceSatelessEJB2));
        // Will be true the condition above is @Stateless so is  shared the EJB, and has the same hashCode()

        req.setAttribute("greeting", serviceSatelessEJB1.greetings("kevin"));
        req.setAttribute("greeting2", serviceSatelessEJB2.greetings("javier"));
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }

}
