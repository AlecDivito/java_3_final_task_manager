package com.proj.controller;

import com.proj.bean.User;
import com.proj.logic.InvalidString;
import com.proj.logic.ProjectHelper;
import com.proj.logic.ServletHelper;
import java.io.IOException;
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
@WebServlet(name = "Register", urlPatterns = {"/Register"})
public class Register extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletHelper sh = new ServletHelper();
        String fname = "", lname = "", company = "", uname = "",pass = "", submit = "";
        try {
            fname = sh.validateString(request.getParameter("firstname")) ;
            lname = sh.validateString(request.getParameter("lastname"));
            company = sh.validateString(request.getParameter("company"));
            uname = sh.validateUsername(request.getParameter("email"));
            pass = sh.validatePassword(request.getParameter("password"));
            submit = sh.validateString(request.getParameter("submitbtn")); 
        } catch (InvalidString is) {
            request.setAttribute("error", "One of your requirements wasn't up to snuff");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }
                
        if(submit.equals("submit")) {
            User u = new User(0, uname, pass, fname, lname, company);
            ProjectHelper ph = new ProjectHelper();
            ph.saveUser(u);
            HttpSession ses = request.getSession();
            u = ph.getUserByLogin(uname, pass);
            ses.setAttribute("id", u.getUserid());
            request.setAttribute("user", u);
            request.getRequestDispatcher("main.jsp").forward(request, response);
        } else {
            request.setAttribute("error", "something failed.. idk what");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }
    }

}
