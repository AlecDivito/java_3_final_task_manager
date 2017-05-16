/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proj.controller;

import com.proj.bean.Project;
import com.proj.bean.Task;
import com.proj.bean.User;
import com.proj.logic.ProjectHelper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
@WebServlet(name = "setUp", urlPatterns = {"/setUp"})
public class setUp extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses = request.getSession(false);
        if(ses == null) { // user is not logged in. Redirect to the index page
            request.setAttribute("error", "You need to create an account before The project can be setup");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        
        Integer projId = null;
        try {
            projId = (ses.getAttribute("projectid") != null) ? 
                (Integer) ses.getAttribute("projectid") :
                (Integer)Integer.parseInt(request.getParameter("projectid"));
            ses.setAttribute("projectid", projId);
        } catch(java.lang.NumberFormatException nfe){
            System.out.println("\n\n Error:" + nfe + ".\n\n");
        }
        if(projId == null) {
            request.setAttribute("error", "You need to create an account before accessing a project that can be setup");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            ProjectHelper ph = new ProjectHelper();
            User u = ph.getUserById( (int)ses.getAttribute("id"));
            
            Project proj = ph.getProjectById(projId);
            List<Task> tasks = new ArrayList(proj.getTasks());
            Collections.sort(tasks);
            request.setAttribute("user", u);
            request.setAttribute("projName", proj.getProjtitle());
            request.setAttribute("tasks", tasks);
            request.getRequestDispatcher("project.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
