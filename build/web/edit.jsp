<%-- 
    Document   : edit
    Created on : Nov 30, 2016, 4:42:54 PM
    Author     : alecdivito
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style/headerStyle.css"/>
        <title>Edit</title>
        <style>
            #message {
                width: 60%;
                color: red;
            }
        </style>
    </head>
    <body>
        <c:import url="includes/header.jsp">
            <c:param name="title" value=": Edit Profile"/>
            <c:param name="link" value="login"/>
            <c:param name="page" value="go back to main"/>
        </c:import> 
        <center>
                <form action="updateProfile" method="post">
                    <p>Change '${user.firstname}' to:<input type="text" name="firstname" placeholder="first name..."></p>
                    <p>Change '${user.lastname}' to:<input type="text" name="lastname" placeholder="last name..."></p>
                    <p>Change '${user.company}' to:<input type="text" name="company" placeholder="company.."></p>
                    <input type="submit" value="update user info"/>
                </form>
                <form action="updateProfile" enctype="multipart/form-data" method="post">
                    <p>Change Picture To:<input type="file" name="file_upload"></p>
                    <p>Current Profile Picture:<img src="${user.profilepic}" width='200px' height="200px"/></p>
                    <input type="submit" name="submit" value="update user photo">	
                    <p id="message">And coming soon if i need to do more for this project:
                    The ability to remove a project, remove yourself from a project
                    of remove one to everyone in your group project</p>
                </form>
        </center>
    </body>
</html>
