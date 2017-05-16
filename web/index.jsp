<%-- 
    Document   : index
    Created on : Nov 20, 2016, 4:32:45 PM
    Author     : alecdivito
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Project Management</title>
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="style/headerStyle.css"/>
    <style type="text/css">
        html {
            background: url(images/pictures/login.jpg);
            background-size: cover;
            background-repeat: no-repeat;
            background-attachment: fixed;
            background-position: top center;
        }
		.FD-forms {
            width: 500px;
            height: 400px;
			text-align: center;
			margin: -200px -250px ;
            display: none;
            background-color: white;
            z-index: 1000;
            padding: 20px;
            position: absolute;
            top: 50%;
            left: 50%;
            box-shadow: 0 0 50px black;
		}
        FD-forms-from {
            width: 250px;
			text-align: center;
			margin: auto;
            background-color: white;
            z-index: 1100;
            padding: 20px;
        }

		.FD-login-form {
			display: block;
			width: 250px;
            background-color: white;
            z-index: 1100;
			text-align: center;
			margin: auto;
		}

		.FD-register-form {
			display: none;
			width: 250px;
            background-color: white;
			text-align: center;
			margin: auto;
            z-index: 1000;
		}
        #id { color:red; }
        
        #overlay {
            position: fixed;
            height: calc(100% - 75px);
            width: 100%;
            left: 0;
            top: 75px;
            z-index: -100;
            background-color: rgba(0, 0, 255, 0.6);
        }
        
        .FD-desc {
            color: black;
            position: absolute;
            width: 800px;
            height: 400px;
            top: 50%;
            left: 50%;
            margin: -200px 0 0 -400px;
        }
        .FD-desc p {font-size: 24px; color: white;}
        #button {
            width: 150px;
            padding: 20px;
            background-color: green;
            border: 1px solid darkgreen;
        }
        
        input[type="text"], input[type="password"], input[type="email"]{
            padding: 10px;
            border: none;
            border-bottom: solid 2px #c9c9c9;
            transition: border 0.3s;
            width: 100%;
            font-family: sans-serif;
            font-size: 14px;
                  }
        input[type="text"]:focus, input[type="password"]:focus, input[type="email"]:focus {  border-bottom: solid 2px #969696;}

        input[type=submit], button {
              margin-top: 5px;
              padding:5px 15px; 
              background:#ccc; 
              border:0 none;
              cursor:pointer;
              -webkit-border-radius: 5px;
              border-radius: 5px;
                font-size: 14px;
          }
          
          input[type=submit]:focus, button:focus {
              background-color: #aaa;
          }
          #error {
              position: fixed;
              bottom: 25px;
              left: calc(50% - 150px);
              width: 300px;
              background-color: red;
              padding: 10px;
          }
	</style>

</head>
<body>
    
<c:import url="includes/header.jsp">
    <c:param name="title" value=": Login"/>
</c:import>
    
<div class="FD-forms">
	<h2 id="header">Login</h2>
	<button id="login">Login</button>
	<button id="register">Register</button>
	<div class="FD-login-form FD-forms-from" >
		<form method="post" action="login">
			<input type="text" name="email" value="${email}" placeholder="email.." required>
			<input type="password" name="password" value="${password}" placeholder="password" required>
			<input type="submit" name="submitbtn" value="submit">
		</form>
	</div>
	<div class="FD-register-form FD-forms-from">
		<form method="post" action="Register">
            <input type="text" name="firstname" value="${firstname}" placeholder="first name..." required>
			<input type="text" name="lastname" value="${lastname}" placeholder="last name..." required>
			<input type="text" name="company" value="${company}" placeholder="company.." required>
            <input type="email" name="email" value="${email}" placeholder="email.." required>
			<input type="password" name="password" value="${password}" placeholder="password.." required>
			<input type="submit" name="submitbtn" value="submit">
		</form>
	</div>
</div>
<center>
    <div class="FD-desc">
        <p>Project Management isn't a option but a life style</p>
        <p>Create Progects that your proud to show your friends</p>
        <div id="button">
            <p>Get Started</p>
        </div>    
    </div>    
</center>
<center>
    <p id='error'>${error}</p>
</center>

    <div id="overlay"></div>    


<script type="text/javascript">
	$("#login").click( function () {
		$('.FD-login-form').eq(0).slideDown(250);
		$('.FD-register-form').eq(0).hide();
		document.getElementById('header').innerHTML = "Register";
	});
	$("#register").click( function () {
		$('.FD-login-form').eq(0).hide();
		$('.FD-register-form').eq(0).slideDown(250);
		document.getElementById('header').innerHTML = "Login";
	});
    
    $("#button").click(function() {
        $(".FD-forms").show(750);
    });
</script>

</body>
</html>