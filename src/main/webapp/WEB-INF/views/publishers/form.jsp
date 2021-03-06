<%--
  Created by IntelliJ IDEA.
  User: rafalrybak
  Date: 04/01/2020
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}/form-publisher"/>
<html>
<head>
    <title>Publishers</title>
</head>
<body>
    <h1>Publisher Form</h1>
    <form:form action="${contextPath}" method="post" modelAttribute="publisher">
        <div>
            Name: <form:input path="name"/>
        </div>
        <div>
            <input type="submit" value="Save">
        </div>
    </form:form>
</body>
</html>
