package com.kevinpina.controllers;

import com.kevinpina.services.impl.ServiceSatelessEJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;

@WebServlet("/stateless_call_programmatically")
public class StatelessEJBCallProgrammaticServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServiceSatelessEJB serviceSatelessEJB1;
        ServiceSatelessEJB serviceSatelessEJB2;

        try {
            // Using JNDI
            InitialContext ctx = new InitialContext();
            // lookup("java:global/nameWar/nameEJBClass!packageEJBInterfaceLocalOrRemote.nameEJBInterface"); // With Local or Remote Interface
            // lookup("java:global/nameWar/nameEJBClass!packageEJBClass.nameEJBClass"); // Without interface
            serviceSatelessEJB1 = (ServiceSatelessEJB) ctx.lookup("java:global/webapp-ejb/ServiceSatelessEJB!com.kevinpina.services.impl.ServiceSatelessEJB");
            serviceSatelessEJB2 = (ServiceSatelessEJB) ctx.lookup("java:global/webapp-ejb/ServiceSatelessEJB!com.kevinpina.services.impl.ServiceSatelessEJB");

            // If we use @Stetefull will not work with context due to is not using @Inject
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Is serviceSatelessEJB1 equals to serviceSatelessEJB2 " + serviceSatelessEJB1.equals(serviceSatelessEJB2));
        // Will be true the condition above is @Stateless so is  shared the EJB, and has the same hashCode()

        req.setAttribute("greeting", serviceSatelessEJB1.greetings("kevin"));
        req.setAttribute("greeting2", serviceSatelessEJB2.greetings("javier"));
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }

}
