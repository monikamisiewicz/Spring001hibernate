<%--
  Created by IntelliJ IDEA.
  User: rafalrybak
  Date: 04/01/2020
  Time: 11:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<body>
<%--@elvariable id="student" type="pl.coderslab.model.Student"--%>
<form:form action="${contextPath}/students/save" method="post" modelAttribute="student">
    <div>
        First name: <form:input path="firstName"/>
    </div>
    <div>
        Last name: <form:input path="lastName"/>
    </div>
    <div>
        <%--@elvariable id="gender" type="java.util.List"--%>
        Gender:<form:radiobuttons path="gender" items="${gender}"/>
    </div>
    <div>
        <%--@elvariable id="countries" type="java.util.List"--%>
        Country: <form:select path="country" items="${countries}"/>
    </div>
    <div>
        Notes: <form:textarea path="notes" cols="10" rows="3"/>
    </div>
    <div>
        Mailing list: <form:checkbox path="mailingList"/>
    </div>
    <div>
        Programming skills: <%--@elvariable id="programmingSkills" type="java.util.List"--%>
        <form:select path="programmingSkills" items="${programmingSkills}" multiple="true"/>
    </div>
    <div>
        Hobbies: <%--@elvariable id="hobbies" type="java.util.List"--%>
        <form:checkboxes path="hobbies" items="${hobbies}"/>
    </div>
    <div>
        <input type="submit" value="Submit">
    </div>
</form:form>
</body>
<head>
    <title>Students</title>
</head>
</html>
