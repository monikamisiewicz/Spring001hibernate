<%--
  Created by IntelliJ IDEA.
  User: rafalrybak
  Date: 04/01/2020
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}/form-book"/>
<html>
<head>
    <title>Book List</title>
</head>
<body>
    <h1>Book list</h1>
    <button>
        <a href="${contextPath}"> New </a>
    </button>

    <ul>
        <c:forEach items="${books}" var="book">
            <li>
                    ${book.id}, ${book.title}, ${book.description}, ${book.rating}, ${book.publisher.name}
                        <button><a href="${contextPath}/edit/${book.id}"> Edit </a></button>
                        <button><a href="${contextPath}/delete/${book.id}"> Delete </a></button>
            </li>
        </c:forEach>
    </ul>
</body>
</html>
