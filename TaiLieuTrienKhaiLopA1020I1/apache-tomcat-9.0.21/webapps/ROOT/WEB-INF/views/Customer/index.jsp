<%--
  Created by IntelliJ IDEA.
  User: 20100
  Date: 6/9/2021
  Time: 6:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>email</th>
        <th>address</th>
        <th>edit</th>
    </tr>
    <c:forEach var="item" items="${listCustomer}">
        <tr>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td>${item.email}</td>
            <td>${item.address}</td>
            <td><a href="/customer/edit?id=${item.id - 1}">edit</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
