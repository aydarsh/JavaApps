<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show Student</title>
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" >
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" >
	    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" ></script>
    </head>
    <body>
	<nav class="navbar navbar-inverse navbar-static-top" role="navigation">
        <div class="container">
	    <ul class="nav navbar-nav navbar-right">
		<li><a href="/HelloSpringMVC/students">Students</a></li>
		<li><a href="/HelloSpringMVC/teachers">Teachers</a></li>
		<li><a href="/HelloSpringMVC/courses">Courses</a></li>
		<li><a href="/HelloSpringMVC/exams">Exams</a></li>
	    </ul>
        </div>
	</nav>
        <h1>Show Student</h1>
<table class="table">
        <tr>
            <th >ID</th>
            <th >Name</th>
            <th >Birthday</th>
            <th >Group No</th>            
        </tr>       
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</a></td>
            <td>${student.birthday}</td>
            <td>${student.groupNo}</td>                
        </tr>        
    </table>
    </body>
</html>