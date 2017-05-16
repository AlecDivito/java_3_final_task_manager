import com.proj.bean.ProjGroup;
import com.proj.bean.Project;
import com.proj.bean.Task;
import com.proj.bean.User;
import com.proj.logic.ProjectHelper;
import com.proj.logic.ServletHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class testHibernate {
    
    private ProjectHelper ph = new ProjectHelper();
    private ServletHelper sh = new ServletHelper();
    
    public static void main(String[] args) {
       new testHibernate();
    }
    
    public testHibernate() {
        List<User> list = new ArrayList<>();
        list.add(new User(0,"email@unique1com.com", "password", "Pablo", "Bablar", "CompA"));
        list.add( new User(0,"email@unique12com.com", "password", "Pablo", "Bablar", "CompB"));
        list.add( new User(0,"email@unique3com.com", "password", "Pablo", "Bablar", "CompC"));
        list.add( new User(0,"email@unique4com.com", "password", "Pablo", "Bablar", "CompD"));
        list.add( new User(0,"email@unique5com.com", "password", "Pablo", "Bablar", "CompE"));
        list.add( new User(0,"email@unique6com.com", "password", "Pablo", "Bablar", "CompF"));
        list.add(new User(0,"email@unique7com.com", "password", "Pablo", "Bablar", "CompG"));
        list.add(new User(0,"email@unique8com.com", "password", "Pablo", "Bablar", "CompH"));
        list.add(new User(0,"email@unique9com.com", "password", "Pablo", "Bablar", "CompI"));
        list.add(new User(0,"email@unique10com.com", "password", "Pablo", "Bablar", "CompJ"));
        list.add(new User(0,"email@unique11com.com", "password", "Pablo", "Bablar", "CompK"));
        list.add(new User(0,"email@unique2com.com", "password", "Pablo", "Bablar", "CompL"));
        list.add(new User(0,"email@unique13com.com", "password", "Pablo", "Bablar", "CompM"));
        list.add(new User(0,"email@unique14com.com", "password", "Pablo", "Bablar", "CompN"));
        list.add(new User(0,"email@unique15com.com", "password", "Pablo", "Bablar", "CompO"));
        list.add(new User(0,"email@unique16com.com", "password", "Pablo", "Bablar", "CompP"));
        list.add(new User(0,"email@unique17com.com", "password", "Pablo", "Bablar", "CompQ"));
        list.add(new User(0,"email@unique18com.com", "password", "Pablo", "Bablar", "CompR"));
        list.add(new User(0,"email@unique19com.com", "password", "Pablo", "Bablar", "CompS"));
        list.add(new User(0,"email@unique20com.com", "password", "Pablo", "Bablar", "CompT"));
        list.add(new User(0,"email@unique1ca.com", "password", "Jesus", "crist", "CompA"));
        list.add( new User(0,"email@unique12ca.com", "password", "Jesus", "crist", "CompB"));
        list.add( new User(0,"email@unique3ca.com", "password", "Jesus", "crist", "CompC"));
        list.add( new User(0,"email@unique4ca.com", "password", "Jesus", "crist", "CompD"));
        list.add( new User(0,"email@unique5ca.com", "password", "Jesus", "crist", "CompE"));
        list.add( new User(0,"email@unique6ca.com", "password", "Jesus", "crist", "CompF"));
        list.add(new User(0,"email@unique7ca.com", "password", "Jesus", "crist", "CompG"));
        list.add(new User(0,"email@unique8ca.com", "password", "Jesus", "crist", "CompH"));
        list.add(new User(0,"email@unique9ca.com", "password", "Jesus", "crist", "CompI"));
        list.add(new User(0,"email@unique10ca.com", "password", "Jesus", "crist", "CompJ"));
        list.add(new User(0,"email@unique11ca.com", "password", "Jesus", "crist", "CompK"));
        list.add(new User(0,"email@unique2ca.com", "password", "Jesus", "crist", "CompL"));
        list.add(new User(0,"email@unique13ca.com", "password", "Jesus", "crist", "CompM"));
        list.add(new User(0,"email@unique14ca.com", "password", "Jesus", "crist", "CompN"));
        list.add(new User(0,"email@unique15ca.com", "password", "Jesus", "crist", "CompO"));
        list.add(new User(0,"email@unique16ca.com", "password", "Jesus", "crist", "CompP"));
        list.add(new User(0,"email@unique17ca.com", "password", "Jesus", "crist", "CompQ"));
        list.add(new User(0,"email@unique18ca.com", "password", "Jesus", "crist", "CompR"));
        list.add(new User(0,"email@unique19ca.com", "password", "Jesus", "crist", "CompS"));
        list.add(new User(0,"email@unique20ca.com", "password", "Jesus", "crist", "CompT"));
        list.add(new User(0,"email@unique1na.com", "password", "God", "noLastName", "CompA"));
        list.add( new User(0,"email@unique12na.com", "password", "God", "noLastName", "CompB"));
        list.add( new User(0,"email@unique3na.com", "password", "God", "noLastName", "CompC"));
        list.add( new User(0,"email@unique4na.com", "password", "God", "noLastName", "CompD"));
        list.add( new User(0,"email@unique5na.com", "password", "God", "noLastName", "CompE"));
        list.add( new User(0,"email@unique6na.com", "password", "God", "noLastName", "CompF"));
        list.add(new User(0,"email@unique7na.com", "password", "God", "noLastName", "CompG"));
        list.add(new User(0,"email@unique8na.com", "password", "God", "noLastName", "CompH"));
        list.add(new User(0,"email@unique9na.com", "password", "God", "noLastName", "CompI"));
        list.add(new User(0,"email@unique10na.com", "password", "God", "noLastName", "CompJ"));
        list.add(new User(0,"email@unique11na.com", "password", "God", "noLastName", "CompK"));
        list.add(new User(0,"email@unique2na.com", "password", "God", "noLastName", "CompL"));
        list.add(new User(0,"email@unique13na.com", "password", "God", "noLastName", "CompM"));
        list.add(new User(0,"email@unique14na.com", "password", "God", "noLastName", "CompN"));
        list.add(new User(0,"email@unique15na.com", "password", "God", "noLastName", "CompO"));
        list.add(new User(0,"email@unique16na.com", "password", "God", "noLastName", "CompP"));
        list.add(new User(0,"email@unique17na.com", "password", "God", "noLastName", "CompQ"));
        list.add(new User(0,"email@unique18na.com", "password", "God", "noLastName", "CompR"));
        list.add(new User(0,"email@unique19na.com", "password", "God", "noLastName", "CompS"));
        list.add(new User(0,"email@unique20na.com", "password", "God", "noLastName", "CompT"));
        list.add(new User(0,"email@unique1not.com", "password", "stevey", "jobby", "CompA"));
        list.add( new User(0,"email@unique12not.com", "password", "stevey", "jobby", "CompB"));
        list.add( new User(0,"email@unique3not.com", "password", "stevey", "jobby", "CompC"));
        list.add( new User(0,"email@unique4not.com", "password", "stevey", "jobby", "CompD"));
        list.add( new User(0,"email@unique5not.com", "password", "stevey", "jobby", "CompE"));
        list.add( new User(0,"email@unique6not.com", "password", "stevey", "jobby", "CompF"));
        list.add(new User(0,"email@unique7not.com", "password", "stevey", "jobby", "CompG"));
        list.add(new User(0,"email@unique8not.com", "password", "stevey", "jobby", "CompH"));
        list.add(new User(0,"email@unique9not.com", "password", "stevey", "jobby", "CompI"));
        list.add(new User(0,"email@unique10not.com", "password", "stevey", "jobby", "CompJ"));
        list.add(new User(0,"email@unique11not.com", "password", "stevey", "jobby", "CompK"));
        list.add(new User(0,"email@unique2not.com", "password", "stevey", "jobby", "CompL"));
        list.add(new User(0,"email@unique13not.com", "password", "stevey", "jobby", "CompM"));
        list.add(new User(0,"email@unique14not.com", "password", "stevey", "jobby", "CompN"));
        list.add(new User(0,"email@unique15not.com", "password", "stevey", "jobby", "CompO"));
        list.add(new User(0,"email@unique16not.com", "password", "stevey", "jobby", "CompP"));
        list.add(new User(0,"email@unique17not.com", "password", "stevey", "jobby", "CompQ"));
        list.add(new User(0,"email@unique18not.com", "password", "stevey", "jobby", "CompR"));
        list.add(new User(0,"email@unique19not.com", "password", "stevey", "jobby", "CompS"));
        list.add(new User(0,"email@unique20not.com", "password", "stevey", "jobby", "CompT"));


        for(User u : list) {
            ph.saveUser(u);
        }
        System.exit(0);
    }
    
    public void getAllUsers() {
        System.out.println("getting all users (max 50)");
        List<User> u = ph.getAllUsers();
        for(User user : u)
            System.out.println(user.toString());
    }
    
    /* get Projects where the user is the only person inside the project */
    public void getPersonalProjects(int userid) { 
        System.out.println("\n\ngetting personal project " + userid);
        List<Project> p = ph.getAllPersonalProjects(userid);

        System.out.println("user " + userid + " has " + p.size() + " personal Projects:");      
        for (Project proj : p) {         
            System.out.print("project: ");
            proj.printObject();
        }
    }
    
    public void intToString() {
        String[] alec = {"1","2","23","435","564","123","asdf","123"};
        int a[] = sh.stringToInt(alec);
        for(int i : a){
            System.out.print(i + ", ");
        }
    }
    
    /* get Projects where the user is the admin and there are ppl in the project */
    public void getGroupProjects(int userid) {
        System.out.println("\n\ngetting group projects that " + userid + " is apart of");
        List<Project> p = ph.getGroupProjectsAccepted(userid);
        
        /* we need to do this inside the project */
        System.out.println("user " + userid + " has " + p.size() + " group Projects where hes admin or part of:");      
        for(Project proj : p) {
            for(ProjGroup pg : proj.getProjGroups()) {
                User u = pg.getUser();
                if(u.getUserid() == userid) {
                    System.out.println("User " + u.getUserid() + " is " + pg.getStatus() + " for " + proj.getProjtitle());
                }
            }
        }
    }

    private void testGetAllUsers() {
        int i[] = {1,2,3,4};
        List<User> list = ph.getAllUsersByIds(i);
        for(User u : list) {
            System.out.println(u.toString());
        }
    }
    
    private void getTaskByUpdate() {
        Task t = ph.getTaskByUpdate(1, "title");
        System.out.println(t.getTaskid() + ", " + t.getTasktitle() + ", " +t.getProject().toString());
    }

    private void findppl() {
       List<User> l = (ph.searchNames("al", null));
       for(User u : l) {
           System.out.println(u.toString());
       }
    }
}
