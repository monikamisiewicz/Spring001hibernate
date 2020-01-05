<%--@elvariable id="student" type="pl.coderslab.model.Student"--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: rafalrybak
  Date: 04/01/2020
  Time: 12:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    First Name: ${student.firstName}
</div>
<div>
    Last name: ${student.lastName}
</div>
<div>
    Gender: ${student.gender}
</div>
<div>
    Country: ${student.country}
</div>
<div>
    Notes: ${student.notes}
</div>
<div>
    Mailing list? ${student.mailingList}
</div>
<div>
    Programming skills:
    <ul>
        <c:forEach items="${student.programmingSkills}" var="skills" varStatus="stat">

            <li>${stat.index + 1}: ${skills} </li>
        </c:forEach>
    </ul>
</div>
<div>
    Hobbies:
    <ul>
        <c:forEach items="${student.hobbies}" var="hobbies" varStatus="stat">
            <li>${stat.index + 1}: ${hobbies}</li>
        </c:forEach>
    </ul>
</div>
</body>
</html>
