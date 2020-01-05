<%--
  Created by IntelliJ IDEA.
  User: rafalrybak
  Date: 04/01/2020
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}/form-book"/>
<html>
<head>
    <title>Books</title>
</head>
<body>
<h1>Books Form</h1>
<form:form action="${contextPath}/edit" method="post" modelAttribute="book">
    <form:hidden path="id"/>
    <div>
        Title: <form:input path="title"/>
    </div>
    <div>
        Description: <form:textarea path="description" cols="20" rows="10"/>
    </div>
    <div>
        Rating: <form:select path="rating" items="${ratings}"/>
    </div>
    <div>
        Publisher: <form:select path="publisher.id" items="${publishers}"
                                itemValue="id" itemLabel="name"/>
    </div>
    <div>
        Authors: <form:select path="authors" items="${authors}"
                              itemValue="id" itemLabel="fullName" multiple="true"/>
    </div>
    <div>
        <input type="submit" value="Update">
    </div>
</form:form>
</body>
</html>
