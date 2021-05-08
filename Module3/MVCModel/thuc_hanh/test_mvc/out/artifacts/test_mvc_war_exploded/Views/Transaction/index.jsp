<%--
  Created by IntelliJ IDEA.
  User: 20100
  Date: 5/7/2021
  Time: 8:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <th>no</th>
        <th>name transaction</th>
        <th>amount transaction</th>
        <th>image transaction</th>
    </tr>
    <c:forEach var="item" items="${listTransaction}" varStatus="stt">
        <tr>
            <td><c:out value="${stt.index + 1}"/></td>
            <td><c:out value="${item.nameTransaction}"/></td>
            <td><c:out value="${item.amountTransaction}"/></td>
            <td>
                <img src="${pageContext.request.contextPath}${item.ulrImgTransaction}" style="width: 80px;" alt="">
            </td>
        </tr>
    </c:forEach>
    <a href="/transaction?create=create">create</a>
</table>
</body>
</html>
