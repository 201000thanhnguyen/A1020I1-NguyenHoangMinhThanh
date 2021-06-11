<%--
  Created by IntelliJ IDEA.
  User: 20100
  Date: 6/11/2021
  Time: 3:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/customer/edit" method="post">
    <input type="hidden" name="id" id="id" value="${customer.id - 1}">
    <label for="name">name</label>
    <input type="text" name="name" id="name" value="${customer.name}"><br>
    <label for="email">email</label>
    <input type="email" name="email" id="email" value="${customer.email}"><br>
    <label for="address">address</label>
    <input type="text" name="address" id="address" value="${customer.address}"><br>
    <input type="submit" name="submit" id="submit" value="submit">
</form>
</body>
</html>
