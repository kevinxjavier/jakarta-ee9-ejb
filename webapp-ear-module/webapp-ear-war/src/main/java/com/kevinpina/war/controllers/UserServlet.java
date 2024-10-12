package com.kevinpina.war.controllers;

import com.kevinpina.ejb.services.UserService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet({"/list", "/"})
public class UserServlet extends HttpServlet {

    @Inject // If use @EJB will not use the Scope @RequestScoped ...
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listUsers", userService.listUsers());
        getServletContext().getRequestDispatcher("/listUsers.jsp").forward(req, resp);
    }

}
