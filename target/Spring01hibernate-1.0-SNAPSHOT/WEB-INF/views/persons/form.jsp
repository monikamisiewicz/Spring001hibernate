<%--
  Created by IntelliJ IDEA.
  User: rafalrybak
  Date: 04/01/2020
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Person Form</title>
</head>
<body>
    <form action="/persons/save" method="post">
        <div>
            <label for="login">Login</label>
            <input id="login" type="text" name="login">
        </div>
        <div>
            <label for="password">Password</label>
            <input id="password" type="password" name="password">
        </div>
        <div>
            <label for="email">E-mail</label>
            <input id="email" type="email" name="email">
        </div>
        <div>
            <input type="submit" value="Submit">
        </div>
    </form>
</body>
</html>
