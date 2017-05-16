/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proj.logic;

import com.proj.bean.ProjGroup;
import com.proj.bean.Project;
import com.proj.bean.SubTask;
import com.proj.bean.Tag;
import com.proj.bean.Task;
import com.proj.bean.User;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author alecdivito
 */
public class ServletHelper {
    
    public String validateString(String str) throws InvalidString {
        if(str == null) {
            throw new InvalidString("String for some reason is null");
        }
        int lng = str.length();
        if(lng <= 1) {
            throw new InvalidString("String needs to be more than 1 character long");
        }
        if(lng > 64) {
            throw new InvalidString("String needs to be less than 64 characters long");
        }
        return str.trim();
    }
    
    public String validatePassword(String pass) throws InvalidString{
        int lng = pass.length();
        if(lng <= 4) {
            throw new InvalidString("The password needs to be more than 4 characters long");
        }
        if(lng > 64) {
            throw new InvalidString("The password cant be more then 64 characters long");
        }
        // maybe we can enctpy the password here
        return pass.trim();
    }
    
    public String validateUsername(String user) throws InvalidString{
        if(user.length() > 64) {
            throw new InvalidString("The Email cannot be more then 64 characters!");
        } else if(user.length() <= 1){
            throw new InvalidString("The Email needs to be more than 1 character long");
        }
        ProjectHelper ph = new ProjectHelper();
        if(ph.usernameExist(user)) {
           throw new InvalidString("The username is already in use. Please use another one"); 
        }
        return user.trim();
    }

    public String[] validateStringArray(String[] str) throws InvalidString {
        int i;
        for(i = 0; i < str.length; i++) {
            validateString(str[i]);
        }
        return str;
    }

    public String validateLongString(String str) throws InvalidString {
        int lng = str.length();
        if(lng <= 1) {
            throw new InvalidString("String needs to be more than 1 character long");
        }
        if(lng > 512) {
            throw new InvalidString("String needs to be less than 512 characters long");
        }
        return str.trim();
    }

    public String[] validateColors(String[] str) throws InvalidString{
        try {
            for(String s : str) {
                validateString(s);
                if(!s.substring(0, 4).equals("col-")) {
                    throw new InvalidString(s + ": String color does not meet expectations (does not start with 'col-')");
                }
            }
        } catch(InvalidString e) {
            throw new InvalidString(e.getMessage());
        }
        return str;
    }

    public Set<Tag> createTagList(SubTask subTask, List<String> tagname, List<String> tagColorClass) {
        Set<Tag> list = new HashSet<>();
        int i;
        for(i = 0; i < tagname.size(); i++) {
            list.add(new Tag(0, subTask, tagname.get(i), tagColorClass.get(i)));
        }
        return list;
    }
    
    public Task[] createTaskList(Project proj, String[] titles) {
        Task[] list = new Task[titles.length];
        int i;
        for(i = 0; i < titles.length; i++) {
            list[i] = new Task(0, proj,titles[i]);
        }
        return list;
    }
    
    
    public List<ProjGroup> createProjGroupList(List<User> users, Project proj, User admin) {
        List<ProjGroup> list = new ArrayList<>(0);
        if(users.isEmpty()) {
            return null;
        } else {
            users.stream().forEach((u) -> {
                if(admin.getUserid() != u.getUserid()){
                    list.add(new ProjGroup(0, proj, u, false, DataConstants.GRO_PENDING));
                }
            });
            list.add(new ProjGroup(0, proj, admin, true, DataConstants.GRO_ACCEPTED));
        }
        return list;
    }

    /* Convert a string of numbers to numbers
    If The string is not a number, the index will become -1
    ex("asd","df","123") == (-1,-1,123)*/
    public int[] stringToInt(String[] group) {
        if(group.length == 0) {
            return new int[0];
        }
        int groupNum[] = new int[group.length];
        int i = 0;
        try { 
            for(i = 0; i < groupNum.length; i++) {
                groupNum[i] = (int)Integer.parseInt(group[i]);
            }
        } catch(java.lang.NumberFormatException e) {
            System.out.println("SH:stringToInt():couldn't convert string to number");
            groupNum[i] = -1;
        }
        return groupNum;
    }

    /* Returns the old subTasks if it can be found, else returns null */
    public SubTask findOldSubtask(Task oldTask, String subTitle) {
        for(SubTask st : oldTask.getSubTasks()) {
            if(st.getSubtitle().equals(subTitle)) {
                return st;
            }
        }
        return null;
    }




    
}
