package com.proj.rest;

import com.google.gson.Gson;
import com.proj.bean.User;
import com.proj.bean.MetaUser;
import com.proj.logic.ProjectHelper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alecdivito
 */
@WebServlet(name = "getNames", urlPatterns = {"/getNames"})
public class getNames extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("friend-name");
        String comp = request.getParameter("comapny");

        // send back a list of responses
        ProjectHelper ph = new ProjectHelper(); 
        List<User> list = ph.searchNames(name, comp);
        List<MetaUser> meta = new ArrayList<>();
        for(User u : list) {
            meta.add(new MetaUser(u.getUserid(), u.getFirstname() +" "
                    + u.getLastname(), u.getProfilepic(), u.getCompany()));
        }
        String jsonResponse = new Gson().toJson(meta);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(jsonResponse);
    }
}
