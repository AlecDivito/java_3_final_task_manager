/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proj.controller;

import com.proj.bean.ProjGroup;
import com.proj.bean.Project;
import com.proj.bean.Task;
import com.proj.bean.User;
import com.proj.logic.InvalidString;
import com.proj.logic.ProjectHelper;
import com.proj.logic.ServletHelper;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 3. make sure the possible tag values, and colors are going into the database
 * 4. make sure the task titles are going into the database
 * 5. make sure if other "friends" users are added that they are added to projGroup table
 * 
 * @author alecdivito
 */
@WebServlet(name = "Create", urlPatterns = {"/CreateProject"})
public class Create extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses = request.getSession(false);
        if(ses == null) { // user is not logged in. Redirect to the index page
            redirect(response, request, "index.jsp", "You  need to create an account before you create a project");
            return;
        }        
        ServletHelper sh = new ServletHelper();
        String projName = "", projDesc = "", taskTitles[] = {};
        int groupMembers[] = {};
        try {
            projName = sh.validateString(request.getParameter("name")) ;
            projDesc = sh.validateLongString(request.getParameter("descrption"));
            taskTitles = sh.validateStringArray(request.getParameterValues("task"));
            groupMembers = sh.stringToInt(request.getParameterValues("member"));
        } catch (InvalidString is) {
            redirect(response, request, "create.jsp", is.toString());
            return;
        } catch (Exception e) {
            //redirect(response, request, "create.jsp", e.toString());
            //return;
        }
        ProjectHelper ph = new ProjectHelper();
        // Setup the users and the tasks
        User user = ph.getUserById((int) ses.getAttribute("id"));
        Project proj = new Project(0,user, projName, projDesc);
        Task taskList[] = sh.createTaskList(proj, taskTitles);
        // Setup the members of the newly created project
        List<User> members = ph.getAllUsersByIds(groupMembers);
        List<ProjGroup> groupMemList = sh.createProjGroupList(members, proj, user);
        // try and save the newly created project
        if(ph.saveNewProject(proj, taskList, groupMemList)) {
            ses.setAttribute("projectid", proj.getProjid());
            response.sendRedirect("/Java3Project/setUp");            
        } else {
            redirect(response, request, "create.jsp", "there was a problem creating you project");
        }            
    }
    
    private void redirect(HttpServletResponse response, HttpServletRequest request,
            String page, String error) throws ServletException, IOException {
        request.setAttribute("error", error);
        request.getRequestDispatcher(page).forward(request, response);
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
