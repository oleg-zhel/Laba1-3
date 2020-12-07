<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: oaren
  Date: 09.11.2020
  Time: 13:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="css/edit.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<div class="edit-area">
    <table class="edit-table">
        <thead>
        <tr>
            <th>Місце</th>
            <th>Номер</th>
            <th>Ціна</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <form action="${pageContext.request.contextPath}/servlets.roomEditServlet" method="post">
            <input type="hidden" name="idToEdit" value="<%=request.getParameter("edit")%>"/>
            <tr>
                <td><input type="text" class="myInputEdit" name="myInput1"
                           placeholder="Місце"></td>
                <td><input type="text" class="myInputEdit" name="myInput2"
                           placeholder="Номер"></td>
                <td><input type="text" class="myInputEdit" name="myInput3"
                           placeholder="Ціна"></td>
                <th>
                    <button type="submit" class="btnEdit"></button>
                </th>
            </tr>
        </form>
        </tbody>
    </table>
</div>
</body>
</html>
