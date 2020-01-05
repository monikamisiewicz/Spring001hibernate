<%--
  Created by IntelliJ IDEA.
  User: rafalrybak
  Date: 04/01/2020
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Form with bind</title>
</head>
<body>
<%--@elvariable id="person" type="pl.coderslab.model.Person"--%>
<form:form action="/persons/save1" method="post" modelAttribute="person">
    <div>
        <label for="login">Login</label>
        <form:input path="login" id="login" type="text" name="login"/>
    </div>
    <div>
        <label for="password">Password</label>
        <form:password path="password" id="password" name="password"/>
    </div>
    <div>
        <label for="email">E-mail</label>
        <from:input path="email" id="email" type="email" name="email"/>
    </div>
    <div>
        <input type="submit" value="Submit">
    </div>
</form:form>
</body>
</html>
