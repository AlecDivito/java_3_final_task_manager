package com.proj.rest;

import com.google.gson.Gson;
import com.proj.bean.SubTask;
import com.proj.bean.Tag;
import com.proj.bean.Task;
import com.proj.bean.User;
import com.proj.logic.ProjectHelper;
import com.proj.logic.ServletHelper;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "updatePosition", urlPatterns = {"/updatePosition"})
public class updatePosition extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses = request.getSession(false);
        if(ses == null) { // user is not logged in. can't update.
            return;
        }
        ProjectHelper ph = new ProjectHelper();
        
        int projid = (int)ses.getAttribute("projectid");
        Map<String, Object> json = new Gson().fromJson(request.getParameter("dataObject"), Map.class);

        String oldTaskTitle = ((String) json.get("oldtaskTitle")).trim();
        String newTaskTitle = ((String) json.get("newtaskTitle")).trim();
        String subTitle = ((String) json.get("subTitle")).trim();
        String subAction = ((String) json.get("action")).trim();
        
        ServletHelper sh = new ServletHelper();
        Task oldTask = ph.getTaskByUpdate(projid, oldTaskTitle);
        Task newTask = ph.getTaskByUpdate(projid, newTaskTitle);
        if(oldTask.getTaskid() == newTask.getTaskid()) {
            return;
        }
        SubTask subTask = sh.findOldSubtask(oldTask, subTitle);
        if(subTask == null) {
            System.out.println("\n\nERROR: SUBTASK COULD NOT BE FOUND IN UPDATEPOSITION \n\n");
            return;
        }
        subTask.setActiondesc(subAction);
        subTask.setTask(newTask);
        subTask.setActiontime(new Date());
        ph.updateSubTask(subTask);
    }


}
