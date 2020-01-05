<%--
  Created by IntelliJ IDEA.
  User: rafalrybak
  Date: 04/01/2020
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}/form-book"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
    JESTES PEWNY?
    <a href="${contextPath}/delete-action/${bookId}?action=true"> TAK </a>
    <br>
    <a href="${contextPath}/delete-action/${bookId}?action=false"> NIE </a>
</body>
</html>
