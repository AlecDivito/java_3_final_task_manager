<%-- 
    Document   : create
    Created on : Nov 20, 2016, 10:14:55 PM
    Author     : alecdivito
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Create</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="style/create_css.css"/>
    <link rel="stylesheet" type="text/css" href="style/headerStyle.css"/>
</head>
<body>
<c:import url="includes/header.jsp">
    <c:param name="title" value=" : Create A Project"/>
    <c:param name="link" value="login"/>
    <c:param name="page" value="main"/>
</c:import>   
    
<main>    
    <center>
        <form id="project" method="post" action="CreateProject">
            <label>Name of Project:<input type="text" name="name" required></label><br>
            <label>Description of Project:<input type="text" name="descrption" required></label><br>
            <label>Column 1:<input type="text" name="task" value="task 1" required></label>
            <label>Column 2:<input type="text" name="task" value="task 2" required></label><br>
            <label>Column 3:<input type="text" name="task" value="task 3" required></label>
            <label>Column 4:<input type="text" name="task" value="task 4" required></label><br>
            <input type="submit" name="submit" value="YOU BUILD THAT PROJECT YO">
        </form>
    </center>

    <center>
        <p>You can also search for friends you would like to join your project!</p>
        <p>Try it by typeing in there name or name and company they are part of to refine the search</p>
        <form id="name-form">
            <label>Company: <input type="text" class="name-input" name="comapny" required></label>
            <label>Find Co-workers/Friends<input class="name-input" type="text" name="friend-name"></label><br>
        </form>
        <div class="friend-box">
            <h2>Accepted:</h2>
            <ul id="selected">

            </ul>	
        </div>

        <div class="friend-box">
            <h2>search:</h2>
            <ul id="search">
            </ul>
        </div>
    </center>
</main>        
        
<p>${error}</p>

<script type="text/javascript" src="javascript/create_js.js" ></script>
</body>
</html>
