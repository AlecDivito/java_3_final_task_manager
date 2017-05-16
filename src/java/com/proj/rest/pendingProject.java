package com.proj.rest;

import com.proj.bean.ProjGroup;
import com.proj.bean.User;
import com.proj.logic.DataConstants;
import com.proj.logic.ProjectHelper;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "pendingProject", urlPatterns = {"/pendingProject"})
public class pendingProject extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses = request.getSession(false);
        if(ses == null) { // user is not logged in. can't update.
            return;
        }
        ProjectHelper ph = new ProjectHelper();
        User user = ph.getUserById((int)ses.getAttribute("id"));
        String join = "";Integer projid = null;
        try {
            join = request.getParameter("join");
            projid = Integer.parseInt(request.getParameter("proj"));
        } catch(Exception e) {
            response.getOutputStream().print("{error:projid was probably not a number}");
            return;
        }
        
        ProjGroup projGroup = ph.getGroupProject(projid, user.getUserid());
        if(join.equals("yes")){
            projGroup.setStatus(DataConstants.GRO_ACCEPTED);
            ph.updateProjGroup(projGroup);
        } else if( join.equals("no")) {
            projGroup.setStatus(DataConstants.GRO_REMOVED);
            ph.updateProjGroup(projGroup);
        } else {
            response.getOutputStream().print("{error:join did not equal yes or no}");
            return;
        }
        response.getOutputStream().print("{error:please refersh the page to see the new project}");
    }
}
