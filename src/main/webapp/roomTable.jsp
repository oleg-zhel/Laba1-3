<%@ page import="services.DaoService" %><%--
  Created by IntelliJ IDEA.
  User: oaren
  Date: 02.11.2020
  Time: 18:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>LB1</title>
    <link href="css/clientTable.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<div class="outer">
    <div class="area-under-table">
        <form action="${pageContext.request.contextPath}/servlets.roomSearchServlet" method="post">
            <div class="select-area">
                <select name="searchOption">
                    <option class="other" value="location">Місце</option>
                    <option class="other" value="number">Номер</option>
                    <option class="other" value="price">Ціна</option>
                </select>
            </div>
            <div class="search-area">
                <input type="text" name="searchInput" class="myInput" placeholder="Пошук ...">
            </div>
            <div class="search-icon">
                <button type="submit" class="btnSearch"></button>
            </div>
        </form>
    </div>
    <table class="content-table">
        <thead>
        <tr>
            <th>Місце</th>
            <th>Номер</th>
            <th>Ціна</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="room" items="${DaoService.roomDAO.roomList}" varStatus="row">
            <tr>
                <td><c:out value="${room.location}"/></td>
                <td><c:out value="${room.number}"/></td>
                <td><c:out value="${room.price}"/></td>
                <th>
                    <form action="${pageContext.request.contextPath}/servlets.roomDeleteServlet" method="post">
                        <c:if test="${row.count % 2 != 0}">
                            <button type="submit" name="remove" value="${room.id}" class="btnRemove"></button>
                        </c:if>
                        <c:if test="${row.count % 2 == 0}">
                            <button type="submit" name="remove" value="${room.id}" class="btnRemoveG"></button>
                        </c:if>
                    </form>
                </th>
                <th>
                    <form action="${pageContext.request.contextPath}/roomEdit.jsp" method="post">
                        <c:if test="${row.count % 2 != 0}">
                            <button type="submit" name="edit" value="${room.id}" class="btnEdit"></button>
                        </c:if>
                        <c:if test="${row.count % 2 == 0}">
                            <button type="submit" name="edit" value="${room.id}" class="btnEditG"></button>
                        </c:if>
                    </form>
                </th>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="add-area">
        <table class="add-table">
            <thead>
            <tr>
                <th>Місце</th>
                <th>Номер</th>
                <th>Ціна</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <form action="${pageContext.request.contextPath}/servlets.roomAddServlet" method="post">
                <tr>
                    <td><input type="text" class="myInputAdd" name="myInput1"
                               placeholder="Місце"></td>
                    <td><input type="text" class="myInputAdd" name="myInput2"
                               placeholder="Номер"></td>
                    <td><input type="text" class="myInputAdd" name="myInput3"
                               placeholder="Ціна"></td>
                    <th>
                        <button type="submit" class="btnAdd"></button>
                    </th>
                </tr>
            </form>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
