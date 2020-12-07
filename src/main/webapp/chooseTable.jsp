<%--
  Created by IntelliJ IDEA.
  User: oaren
  Date: 02.12.2020
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>LB1</title>
    <link href="css/chooseTable.css" type="text/css" rel="stylesheet"></link>
</head>
<body>
<div class="outer">
    <div class="inner1">
        <div class="btnbx">
            <form action="${pageContext.request.contextPath}/clientTable.jsp" method="post">
                <input type="hidden" name="role" value="${role}">
                <div class="btnd">
                    <button type="submit" name="button" value="buttonClients" class="btn"><span>Клієнти</span></button>
                </div>
            </form>
            <form action="${pageContext.request.contextPath}/servlets.toTableServlet" method="post">
                <input type="hidden" name="role" value="${role}">
                <div class="btnd">
                    <button type="submit" name="button" value="buttonCars" class="btn"><span>Кімнати</span></button>
                </div>
            </form>
            <form action="${pageContext.request.contextPath}/" method="post">
                <input type="hidden" name="role" value="${role}">
                <div class="btnd">
                    <button type="submit" name="button" value="buttonRent" class="btn"><span>Броні</span></button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>