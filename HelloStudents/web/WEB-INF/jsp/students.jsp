<%-- 
    Document   : students
    Created on : Mar 10, 2017, 11:44:51 PM
    Author     : aydar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Students List</title>
        <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
    </head>
    <body>
        <a href="../../index.jsp" >Back to main menu</a>
    <br/>
    <br/>
    
    <h1>Students List</h1>
    <c:if test="${!empty listStudents}">
        <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Name</th>
            <th width="120">Birthday</th>
            <th width="120">Group No</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listStudents}" var="student">
            <tr>
                <td>${student.id}</td>
                <td><a href="/bookdata/${student.id}" target="_blank">${student.name}</a></td>
                <td>${student.birthday}</td>
                <td>${student.groupNo}</td>
                <td><a href="<c:url value='/edit/${student.id}'/>">Edit</a></td>
                <td><a href="<c:url value='/remove/${student.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
    </c:if>
    
    <h1>Add a Book</h1>

<c:url var="addAction" value="/books/add"/>

<form:form action="${addAction}" commandName="student">
    <table>
        <c:if test="${!empty student.name}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="name">
                    <spring:message text="Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="name"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="birthday">
                    <spring:message text="Birthday"/>
                </form:label>
            </td>
            <td>
                <form:input path="birthday"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="groupNo">
                    <spring:message text="Group No"/>
                </form:label>
            </td>
            <td>
                <form:input path="groupNo"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty student.name}">
                    <input type="submit"
                           value="<spring:message text="Edit Student"/>"/>
                </c:if>
                <c:if test="${empty student.name}">
                    <input type="submit"
                           value="<spring:message text="Add Student"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
    </form:form>
    </body>
</html>
