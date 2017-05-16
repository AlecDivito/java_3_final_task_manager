package com.proj.controller;

import com.proj.bean.User;
import com.proj.logic.ProjectHelper;
import java.io.IOException;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author alecdivito
 */
@WebServlet(name = "login", urlPatterns = {"/login"})
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses = request.getSession();
        ProjectHelper ph = new ProjectHelper();
        Integer id = (Integer)ses.getAttribute("id");
        User user = null;
        if(id == null) {
            String username = request.getParameter("email");
            String password = request.getParameter("password");
            user = ph.getUserByLogin(username, password);
            try {
                ses.setAttribute("id", user.getUserid());                
            } catch(NullPointerException npe) {
                request.setAttribute("error", "your username or password is incorrecet!");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                return;
            }
        } else {
            user = ph.getUserById(id);
        }
        try {
            request.setAttribute("user", user);
            request.setAttribute("personal", ph.getAllPersonalProjects(user.getUserid()));
            request.setAttribute("group", ph.getGroupProjectsAccepted(user.getUserid()));
            request.setAttribute("pending", ph.getGroupProjectsPending(user.getUserid()));
            request.getRequestDispatcher("main.jsp").forward(request, response);
        } catch(java.lang.NullPointerException n) {
            System.out.println("error");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses = request.getSession(false);
        ProjectHelper ph = new ProjectHelper();
        Integer id = (Integer)ses.getAttribute("id");
        User user = null;
        if(id == null) {
            request.setAttribute("error", "Please relog in to the website!");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            return;
        } else {
            user = ph.getUserById(id);
        }
        request.setAttribute("user", user);
        request.setAttribute("personal", ph.getAllPersonalProjects(user.getUserid()));
        request.setAttribute("group", ph.getGroupProjectsAccepted(user.getUserid()));
        request.setAttribute("pending", ph.getGroupProjectsPending(user.getUserid()));
        request.getRequestDispatcher("main.jsp").forward(request, response);
    }
    
    
}
