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
        <form action="${pageContext.request.contextPath}/servlets.clientSearchServlet" method="post">
            <div class="select-area">
                <select name="searchOption">
                    <option class="other" value="firstName">Ім'я</option>
                    <option class="other" value="secondName">Прізвище</option>
                    <option class="other" value="phoneNumber">Номер Телефону</option>
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
            <th>Ім'я</th>
            <th>Прізвище</th>
            <th>Номер телефону</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="client" items="${DaoService.clientDAO.clientList}" varStatus="row">
            <tr>
                <td><c:out value="${client.firstName}"/></td>
                <td><c:out value="${client.secondName}"/></td>
                <td><c:out value="${client.phoneNumber}"/></td>
                <th>
                    <form action="${pageContext.request.contextPath}/servlets.clientDeleteServlet" method="post">
                        <c:if test="${row.count % 2 != 0}">
                            <button type="submit" name="remove" value="${client.id}" class="btnRemove"></button>
                        </c:if>
                        <c:if test="${row.count % 2 == 0}">
                            <button type="submit" name="remove" value="${client.id}" class="btnRemoveG"></button>
                        </c:if>
                    </form>
                </th>
                <th>
                    <form action="${pageContext.request.contextPath}/clientEdit.jsp" method="post">
                        <c:if test="${row.count % 2 != 0}">
                            <button type="submit" name="edit" value="${client.id}" class="btnEdit"></button>
                        </c:if>
                        <c:if test="${row.count % 2 == 0}">
                            <button type="submit" name="edit" value="${client.id}" class="btnEditG"></button>
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
                <th>Ім'я</th>
                <th>Прізвище</th>
                <th>Номер Телефону</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <form action="${pageContext.request.contextPath}/servlets.clientAddServlet" method="post">
                <tr>
                    <td><input type="text" class="myInputAdd" name="myInput1"
                               placeholder="Ім'я"></td>
                    <td><input type="text" class="myInputAdd" name="myInput2"
                               placeholder="Прізвище"></td>
                    <td><input type="text" class="myInputAdd" name="myInput3"
                               placeholder="Номер телефону"></td>
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
