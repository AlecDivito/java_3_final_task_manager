package com.proj.controller;

import com.proj.bean.User;
import com.proj.logic.InvalidString;
import com.proj.logic.ProjectHelper;
import com.proj.logic.ServletHelper;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class updateProfile extends HttpServlet {
    
    private boolean isMultipart;
    private String filePath;
    private int maxFileSize = 100 * 1024;
    private int maxMemSize = 4 * 1024;
    private File file ;
   
    
   public void init( ){
      // Get the file location where it would be stored.
      filePath = getServletContext().getInitParameter("file-upload"); 
   }
   public void doPost(HttpServletRequest request, 
               HttpServletResponse response)
              throws ServletException, java.io.IOException {
        HttpSession ses = request.getSession(false);
        if(ses == null) { // user is not logged in. Redirect to the index page
            request.setAttribute("error", "You need to create an account before You edit your profile");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }   
        ProjectHelper ph = new ProjectHelper();
        User user = ph.getUserById((int) ses.getAttribute("id"));
        String fname = request.getParameter("firstname");
        String lname = request.getParameter("lastname");
        String company = request.getParameter("company"); 
        if (fname != null)   {user.setFirstname(fname);}
        if (lname != null)   {user.setLastname(lname);}
        if (company != null) {user.setCompany(company);}

        
        
        // Check that we have a file upload request
        isMultipart = ServletFileUpload.isMultipartContent(request);
        if(isMultipart) {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            // maximum size that will be stored in memory
            factory.setSizeThreshold(maxMemSize);
            // Location to save data that is larger than maxMemSize.
            factory.setRepository(new File("/tmp"));

            // Create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload(factory);
            // maximum file size to be uploaded.
            upload.setSizeMax( maxFileSize );

            try{ 
                // Parse the request to get file items.
                List fileItems = upload.parseRequest(request);

                // Process the uploaded file items
                Iterator i = fileItems.iterator();

                while ( i.hasNext () ) 
                {
                    FileItem fi = (FileItem)i.next();
                    if ( !fi.isFormField () )	
                    {
                        // Get the uploaded file parameters
                        String fileName = fi.getName();
                        String newName = user.getUserid() + fileName.substring(fileName.length() - 4, fileName.length());
                        // Write the file
                        file = new File( filePath + newName) ;
                        fi.write( file ) ;
                        user.setProfilepic("images/" + newName);
                    }
                }
            }catch(Exception ex) {
                System.out.println(ex);
            }
        }
       ph.updateUser(user);
       request.getRequestDispatcher("login").forward(request, response);
   }

}
