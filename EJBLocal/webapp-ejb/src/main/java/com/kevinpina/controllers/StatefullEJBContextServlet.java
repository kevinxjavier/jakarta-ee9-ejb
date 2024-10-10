package com.kevinpina.controllers;

import com.kevinpina.services.impl.ServiceSatefullContextEJB;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/statefull_request_scope")
public class StatefullEJBContextServlet extends HttpServlet {

    /*
        In Servlet is ok used @Stateless EJB, but it is not good for @Statefull because of
        the Servlet are static and singleton will treat the @Statefull EJB as a @Stateless.

        It is not ok have @Stateless EJB with a context, e.g.; @Stateless @RequestScope class ...
        but @Statefull with context are ok, e.g.; @Statefull @RequestScope class ...
     */

    // This EJB is Local due to is used on the same project so no need of JNDI
    @Inject //@EJB // Also works always, but we want that get the instance first from CDI context
    // When we use CDI context (@RequestScope, and so on) in an EJB we use @Inject instead of @EJB otherwise will not work the context
    private ServiceSatefullContextEJB serviceSatefullContextEJB1;

    @Inject
    private ServiceSatefullContextEJB serviceSatefullContextEJB2;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("Is ServiceSatefullContextEJB1 equals to ServiceSatefullContextEJB2 " + serviceSatefullContextEJB1.equals(serviceSatefullContextEJB2));
        // Will be true the condition above, is @Statefull but with the @RequestScope context is shared the EJB "per Request", so they have the same hashCode()
        // in the second call will have the same hasCode but for that new request and different from the first one call.
        /*
           The instances of serviceSatefullContextEJB1 and serviceSatefullContextEJB2 are equals but for the same request.
           And this is due to first will fetch the EJB from the CDI context (when we use @Inject) and if not exists
           will fetch EJB context if not exists here will create it and leave it in CDI context, so next time will fetch it
           in CDI context.
         */

        req.setAttribute("greeting", serviceSatefullContextEJB1.greetings("kevin"));
        req.setAttribute("greeting2", serviceSatefullContextEJB2.greetings("javier"));
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }

}
