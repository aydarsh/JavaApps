<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Student</title>
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
        <h1>Edit Student</h1>
<form:form class="form-inline" action="/students/{id}" method="put" modelAttribute="student">
    <div class="form-group">
	<form:label path="name">Name</form:label>
	<form:input class="form-control" path="name" placeholder="Name"/>
    </div>
    <div class="form-group">
	<form:label path="birthday">Birthday</form:label>
	<form:input type="date" class="form-control" path="birthday" placeholder="dd.mm.yyyy"/>
    </div>
    <div class="form-group">
	<form:label path="groupNo">Group No</form:label>
	<form:input class="form-control" path="groupNo" placeholder="Group No"/>
    </div>
    <button type="submit" class="btn btn-default">Edit Student</button>
</form:form>
    </body>
</html>