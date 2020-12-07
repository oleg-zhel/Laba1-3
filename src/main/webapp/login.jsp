<%--
  Created by IntelliJ IDEA.
  User: oaren
  Date: 02.12.2020
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Логін</title>
    <link href="css/login.css" type="text/css" rel="stylesheet">
</head>
<body>
<div class="outer">
    <div class="inner1">
        <form action="${pageContext.request.contextPath}/servlets.loginServlet" method="post">
            <div class="container">
                <label><b>Логін</b></label>
                <input type="text" placeholder="Введіть логін" name="login" required>

                <label><b>Пароль</b></label>
                <input type="password" placeholder="Введіть пароль" name="password" required>
            </div>
            <div class="btnbox">
                <button type="submit" class="btnLogin"><span>Увійти</span></button>
                <button type="submit" class="btnRegister"><span>Реєстрація</span></button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
