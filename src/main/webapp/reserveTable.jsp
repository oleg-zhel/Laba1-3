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
        <form action="${pageContext.request.contextPath}/servlets.reserveSearchServlet" method="post">
            <div class="select-area">
                <select name="searchOption">
                    <option class="other" value="idClient">Клієнт</option>
                    <option class="other" value="idRoom">Кімната</option>
                    <option class="other" value="length">Тривалість</option>
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
            <th>Клієнт</th>
            <th>Кімната</th>
            <th>Тривалість</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="reserve" items="${DaoService.reserveDAO.reserveList}" varStatus="row">
            <tr>
                <td><c:out value="${reserve.idClient}"/></td>
                <td><c:out value="${reserve.idClient}"/></td>
                <td><c:out value="${reserve.length}"/></td>
                <th>
                    <form action="${pageContext.request.contextPath}/servlets.reserveDeleteServlet" method="post">
                        <c:if test="${row.count % 2 != 0}">
                            <button type="submit" name="remove" value="${reserve.id}" class="btnRemove"></button>
                        </c:if>
                        <c:if test="${row.count % 2 == 0}">
                            <button type="submit" name="remove" value="${reserve.id}" class="btnRemoveG"></button>
                        </c:if>
                    </form>
                </th>
                <th>
                    <form action="${pageContext.request.contextPath}/roomEdit.jsp" method="post">
                        <c:if test="${row.count % 2 != 0}">
                            <button type="submit" name="edit" value="${reserve.id}" class="btnEdit"></button>
                        </c:if>
                        <c:if test="${row.count % 2 == 0}">
                            <button type="submit" name="edit" value="${reserve.id}" class="btnEditG"></button>
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
                <th>Клієнт</th>
                <th>Кімната</th>
                <th>Тривалість</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <form action="${pageContext.request.contextPath}/servlets.reserveAddServlet" method="post">
                <tr>
                    <td><input type="text" class="myInputAdd" name="myInput1"
                               placeholder="Клієнт"></td>
                    <td><input type="text" class="myInputAdd" name="myInput2"
                               placeholder="Кімната"></td>
                    <td><input type="text" class="myInputAdd" name="myInput3"
                               placeholder="Тривалість"></td>
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
