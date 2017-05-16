<%-- 
    Document   : project
    Created on : Nov 23, 2016, 8:32:04 AM
    Author     : alecdivito
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
<head >
    <meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="style/headerStyle.css"/>
    <link rel="stylesheet" type="text/css" href="style/project_css.css"/>
    <link rel="stylesheet" type="text/css" href="style/color.css"/>
    <link rel="stylesheet" type="text/css" href="style/overlay.css"/>
    <link rel="stylesheet" type="text/css" href="style/headerStyle.css"/>
	<title>${projName}</title>
</head>
<body >
    
<c:import url="includes/header.jsp">
    <c:param name="title" value=": ${projName}"/>
    <c:param name="link" value="login"/>
    <c:param name="page" value="go back to main"/>
</c:import>    

<!--<div id="overlay"></div>-->

<main>
    <center><div class="task-move"><b>${projName}</b></div></center>
    <c:if test="${tasks.size() > 0 }">
        <c:forEach var="list" items="${tasks}">
            <article class="dropzone">
                <h4>${list.tasktitle}</h4>
                <c:forEach var="subList" items="${list.subTasks}">
                    <section draggable="true" ondragstart="event.dataTransfer.setData('text/plain',null)"> 
                        ${subList.user.firstname} ${subList.user.lastname}
                        <div class="tag">
                            <img class="tag-profile-pic" src="${subList.user.profilepic}">
                            <c:forEach var="tags" items="${subList.tags}">
                                <div class="item-tag ${tags.tagcolorclass}"></div>
                            </c:forEach>
                            <div><img class="tag-menu-pic" src="images/pictures/ic_more_vert_black_24dp_1x.png"></div>
                        </div>
                        <p class="task-title">${subList.subtitle}</p>
                        <div class="desc">
                            <img class="desc-box closed" src="images/pictures/ic_arrow_drop_down_black_24dp_1x.png" />
                            ${subList.subdesc}
                        </div>
                        <div style="clear:both"></div>
                    </section>
                </c:forEach>
                <footer class="add-task" >
                    <p><img src="images/pictures/ic_add_black_24dp_1x.png" width="25" height="25"> Add A Task...</p>
                </footer>
            </article>
        </c:forEach>
    </c:if>    
</main>

<footer>
</footer>
<script type="text/javascript">
    var page =  {
        project : "${projName}",
        user    : "${user.userid}",
        username: "${user.firstname} ${user.lastname}",
        userPic : "${user.profilepic}"
    };   

</script>
        
<script type="text/javascript" src="javascript/project_js.js"></script>
</body>
</html>