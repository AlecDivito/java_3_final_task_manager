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
import java.util.List;
import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;


/**
 *
 * @author alecdivito
 */
public class ProjectHelper {
    
    Session session = null;
    
    public ProjectHelper() {
        this.session = HibernateUtil.getSessionFactory().openSession();
    }
    
    /* 
        Return a user if found, otherwise return null
    */
    public User getUserByLogin(String username, String password) {
        session.beginTransaction();
        Criteria crit = session.createCriteria(User.class);
        crit.add( Restrictions.and(Restrictions.eq("username", username),
                                   Restrictions.eq("password", password)));
        crit.setMaxResults(1);
        session.getTransaction().commit();
        return (User) crit.uniqueResult();
    }
    
    /* Save a User to the database */ 
    public void saveUser(User u) {        
        session.beginTransaction();
        session.save(u);
        session.getTransaction().commit();
    }
    
    /* Save a project to the database */
    public void saveProject(Project p) {
        session.beginTransaction();
        session.save(p);
        session.getTransaction().commit();
    }
    
    public void saveSubTask(SubTask subtask) {
        session.beginTransaction();
        session.save(subtask);
        session.getTransaction().commit();
    }
    public void updateSubTask(SubTask subtask) {
        session.beginTransaction();
        session.saveOrUpdate(subtask);
        session.getTransaction().commit();
    }
    
    public void updateProjGroup(ProjGroup projGroup) {
        session.beginTransaction();
        session.saveOrUpdate(projGroup);
        session.getTransaction().commit();
    }
    
    public void updateUser(User user) {
        session.beginTransaction();
        session.saveOrUpdate(user);
        session.getTransaction().commit();
    }    
    
    /* batch Save a list of Tasks */
    public void batchSaveTags(Set<Tag> list) {
        session.beginTransaction();
        for(Tag t : list) {
            session.save(t);
        }
        session.getTransaction().commit();
        session.flush();
    }
    
    /* batch Save a list of Tasks */
    public void batchSaveTasks(Task list[]) {
        session.beginTransaction();
        for(Task t : list) {
            session.save(t);
        }
        session.getTransaction().commit();
        session.flush();
    }
   
    /* batch Save a list of Tasks */
    public void batchSaveProjGroup(List<ProjGroup> list) {
        session.beginTransaction();
        for(ProjGroup t : list) {
            session.save(t);
        }
        session.getTransaction().commit();
        session.flush();
    }
     
    public boolean saveNewProject(Project proj, Task tasklist[], List<ProjGroup> groupMem) {
        if(proj != null && tasklist != null) {
            saveProject(proj);
            batchSaveTasks(tasklist);
            if(groupMem != null) {
                batchSaveProjGroup(groupMem); 
            }
            return true;
        }
        return false;
    }
        
    /* Check if a username Exist inside the User table */
    public boolean usernameExist(String username) {
        session.beginTransaction();
        Criteria crit = session.createCriteria(User.class);
        crit.setProjection(Projections.rowCount());
        crit.add( Restrictions.eq("username", username));
        session.getTransaction().commit();
        return ((long)crit.uniqueResult() >= 1 ) ? true : false;
    }
    
    /* Get a User by there id */
    public User getUserById(int userid) {
        session.beginTransaction();
        Criteria crit = session.createCriteria(User.class);
        crit.add(Restrictions.eq("userid", userid));
        User u = (User) crit.uniqueResult();
        session.getTransaction().commit();
        return u;
    }
    
    /* Get all the Users by there id's */
    public List<User> getAllUsersByIds(int userid[]) {
        List<User> list = new ArrayList<>();
        for(Integer i : userid) {
            list.add(getUserById(i));
        }
        return list;
    }
    
    /* Get all the users (limited to 50 right now) */
    public List<User> getAllUsers() {
        session.beginTransaction();
        Criteria cirt = session.createCriteria(User.class);
        cirt.setMaxResults(50);
        List<User> u = cirt.list();
        session.getTransaction().commit();
        return u;
    }
    
    /* Get a project by the id */
    public Project getProjectById(int projId) {
        session.beginTransaction();        
        Criteria cirt = session.createCriteria(Project.class);
        cirt.add( Restrictions.eq("projid", projId));
        session.getTransaction().commit();
        return (Project) cirt.uniqueResult();
    }
    
    /* Get all of users personal tables */
    public List<Project> getAllPersonalProjects(int userid) {
        session.beginTransaction();
        Criteria cr = session.createCriteria(Project.class);
        // check if there are children in the user admins tables
        cr.add( Restrictions.and(Restrictions.eq("user.userid", userid),
                                 Restrictions.sizeEq("projGroups", 0)));     
        session.getTransaction().commit();
        List<Project> list = cr.list();
        if(list == null) {
            return new ArrayList<>(0);
        } else {
            return list;
        }
    }
    
    /*  
    Selects all the users who are creators of the projects
    AND have more than 1 user in there group
    */
    public List<Project> getGroupProjectsByCreator(int userid) {
        session.beginTransaction();
        Criteria cr = session.createCriteria(Project.class);
        cr.createCriteria("user", "u", JoinType.LEFT_OUTER_JOIN); // get the projects creator
        // check if there are children in the user admins tables
        cr.add( Restrictions.and(Restrictions.eq("u.userid", userid),
                                 Restrictions.sizeGt("u.projGroups", 0)));  
        session.getTransaction().commit();
        List<Project> list = cr.list();
        if(list == null) {
            return new ArrayList<>(0);
        } else {
            return list;
        }
    }
    
    /* Selects all the project the user is in BUT not Creator of */
    public List<Project> getGroupProjectsAccepted(int userid) {
        session.beginTransaction();
        Criteria cr = session.createCriteria(Project.class);
        cr.createCriteria("projGroups", "pg", JoinType.LEFT_OUTER_JOIN);
        cr.add( Restrictions.and(
                Restrictions.eq("pg.user.userid", userid),
                Restrictions.eq("pg.status", DataConstants.GRO_ACCEPTED)));
        session.getTransaction().commit();
        List<Project> list = cr.list();
        if(list == null) {
            return new ArrayList<>(0);
        } else {
            return list;
        }
    }
    
    
    public List<Project> getGroupProjectsPending(int userid) {
        session.beginTransaction();
        Criteria cr = session.createCriteria(Project.class);
        cr.createCriteria("projGroups", "pg", JoinType.LEFT_OUTER_JOIN);
        cr.add( Restrictions.and(
                Restrictions.eq("pg.user.userid", userid),
                Restrictions.eq("pg.status", DataConstants.GRO_PENDING)));
        session.getTransaction().commit();
        List<Project> list = cr.list();
        if(list == null) {
            return new ArrayList<>(0);
        } else {
            return list;
        }
    }
    
    public Task getTaskByUpdate(int projid, String taskTitle) {
        session.beginTransaction();
        Criteria cr = session.createCriteria(Task.class);
        cr.add( Restrictions.and(Restrictions.like("tasktitle", taskTitle),
                Restrictions.eq("project.projid", projid)));
        cr.setMaxResults(1);
        session.getTransaction().commit();
        return (Task) cr.uniqueResult();
    }


    /* like searchNames() but includes the company that the person may be 
    from to make the serch more persise and easer to find people */
    public List<User> searchNames(String name, String comp) {
        session.beginTransaction();
        Criteria cr = session.createCriteria(User.class);
        if(comp == null || comp.length() == 0) {
            cr.add(Restrictions.like("firstname", name+"%"));
        } else {
            cr.add(Restrictions.and(Restrictions.like("firstname", name+"%"),
                Restrictions.like("company", comp+"%")));
        }
        cr.setMaxResults(10);
        session.getTransaction().commit();
        return (List<User>) cr.list();
    }

    public ProjGroup getGroupProject(Integer projid, int userid) {
        session.beginTransaction();
        Criteria cr = session.createCriteria(ProjGroup.class);
        cr.add( Restrictions.and(Restrictions.eq("project.projid", projid),
                Restrictions.eq("user.userid", userid)));
        cr.setMaxResults(1);
        session.getTransaction().commit();
        return (ProjGroup) cr.uniqueResult();
    }


   
}
