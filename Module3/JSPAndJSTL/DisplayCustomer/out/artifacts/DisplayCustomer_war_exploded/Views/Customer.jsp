<%--
  Created by IntelliJ IDEA.
  User: MINH-THANH
  Date: 03/05/2021
  Time: 11:06 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2 class="mb-3"><c:out value="${customerList}"/></h2>
<table border="1">
    <tr>
        <th>name</th>
        <th>dateOfBirth</th>
        <th>address</th>
        <th>urlImg</th>
    </tr>
    <c:forEach var="item" items="${customerList}" varStatus="stt" >
        <tr>
            <td>${item.name}</td>
            <td><c:out value="${item.dateOfBirth}"/></td>
            <td><c:out value="">item.address</c:out></td>
            <td>
                <img src="${pageContext.request.contextPath}/Images/noAvatar.jpg" style="width: 50px; height: 50px;"/>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
