<%-- 
    Document   : main
    Created on : Nov 19, 2016, 5:52:38 PM
    Author     : alecdivito
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="ex" uri="/WEB-INF/tlds/proj.tld" %>
<%@ page import="com.proj.bean.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta name="viewport" charset="UTF-8" content="width=device-width, initial-scale=1.0"/>
	<title>main</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="style/mainPageStyle.css"/>
    <link rel="stylesheet" type="text/css" href="style/headerStyle.css"/>
    <link rel="stylesheet" type="text/css" href="style/footerStyle.css"/>
</head>
<body>

<c:import url="includes/header.jsp">
    <c:param name="title" value=""/>
    <c:param name="link" value="logout"/>
    <c:param name="page" value="Logout"/>
</c:import>

<aside>
	<img src="${user.profilepic}" class="image-cirlce" width="200px" height="200px">
	<p>${user.firstname} ${user.lastname}</p>
	<p>${user.company}</p>
    <p><a href="edit">Edit Your Profile Information</a></p>
    <p><a href="logout">Logout</a></p>
</aside>

<main>
	<ul>
		<li id="personal"><a>Personal Tasks</a></li>
		<li id="group"><a>Group Tasks</a></li>
	</ul>

	<div id="create"><a href="create.jsp">Create A new Task</a></div>

	<article>
        
        <!-- foreach personal -->
        <c:forEach var="perPro" items='${personal}'>
            <section id="${perPro.projid}" class="task-personal task-block">
               <h1>
                   <img src="${user.profilepic}" class="image-cirlce" width="25px" height="25px"> 
                   ${perPro.projtitle}
               </h1><hr>
               <h3>${user.firstname} ${user.lastname}</h3>
               <p>${perPro.projdesc}</p>
            </section>	
        </c:forEach>
        
        <c:forEach var="pend" items='${pending}'>
            <div id="${pend.projid}" class="task-pending">
                <div class="text">${pend.user.firstname} ${pend.user.lastname} would like you 
                    to join his project "${pend.projtitle}"</div>
                <div class="accept"><center>Accept</center></div>
                <div class="decline"><center>Decline</center></div>
            </div>	
                <div class="task-pending-clear" style="clear:both"></div>
        </c:forEach>
        
        <!-- foreach group -->
        <c:forEach var="groPro" items='${group}'>
            <section id="${groPro.projid}" class="task-group task-block">
               <h1>
                   <img src="${groPro.user.profilepic}" class="image-cirlce" width="25px" height="25px">
                   ${groPro.projtitle}
               </h1><hr>
               <h3>${groPro.user.firstname} ${groPro.user.lastname}</h3>
               <p>${groPro.projdesc}</p>
            </section>	
        </c:forEach>

	</article>

    <form id="submitForm" method="post" action="setUp">
        <input type="hidden" id="project" name="projectid" value="-1"/>
    </form>
</main>
  
    
<footer>  
    <center>
        <p>Copyright <ex:date/>, Alec Di Vito / Contact information: <a href="divito.alec@gmail.com">
        clickOnIt@toGetMy.Email</a>.</p>
    </center>
</footer>

<script type="text/javascript" src="javascript/main_javascript.js" ></script>

</body>
</html>
