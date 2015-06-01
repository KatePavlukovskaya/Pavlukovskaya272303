<%--
  Created by IntelliJ IDEA.
  User: itechno
  Date: 27.05.2015
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Авторизация</title>


    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/stylelogin.css" />
</head>
<body>

<div id="login-form">
    <h1>АВТОРИЗАЦИЯ</h1>
    <fieldset>
        <form action="/smartcal/j_spring_security_check.action" method="get">
            <input type="text" value="login">
            <input type="password" value="password">
            <input type="submit" value="ВОЙТИ">
        </form>
    </fieldset>
</div>

</body>
</html>
