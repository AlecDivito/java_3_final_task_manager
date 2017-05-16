package com.proj.rest;

import com.google.gson.Gson;
import com.proj.bean.SubTask;
import com.proj.bean.Tag;
import com.proj.bean.Task;
import com.proj.bean.User;
import com.proj.logic.ProjectHelper;
import com.proj.logic.ServletHelper;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "update", urlPatterns = {"/update"})
public class update extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses = request.getSession(false);
        if(ses == null) { // user is not logged in. can't update.
            return;
        }
        ProjectHelper ph = new ProjectHelper();
        
        int projid = (int)ses.getAttribute("projectid");
        User user = ph.getUserById((int)ses.getAttribute("id"));
        Map<String, Object> json = new Gson().fromJson(request.getParameter("data"), Map.class);

        List<String> tags = (List<String>) json.get("tag");
        List<String> colors = (List<String>) json.get("color");
        String taskTitle = ((String) json.get("title")).trim();
        String subTitle = ((String) json.get("subTitle")).trim();
        String subDesc = ((String) json.get("desc")).trim();
        String subAction = ((String) json.get("action")).trim();
        
        ServletHelper sh = new ServletHelper();
        Task task = ph.getTaskByUpdate(projid, taskTitle);
        SubTask subtask = new SubTask(0, task, user, subTitle, subDesc, subAction);
        ph.saveSubTask(subtask);
        Set<Tag> tagSet = sh.createTagList(subtask, tags, colors);
        ph.batchSaveTags(tagSet);
    }
}
