<%--
  Created by IntelliJ IDEA.
  User: 20100
  Date: 5/7/2021
  Time: 8:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>create transaction</h3>
<form action="/transaction" method="post">
    <label for="nameTransaction">name transaction</label>
    <input type="text" name="nameTransaction" id="nameTransaction">
    <br>
    <label for="amountTransaction">amount transaction</label>
    <input type="number" step="0.01" name="amountTransaction" id="amountTransaction">
    <br>
    <input type="submit" name="submitTransaciton" id="submitTransaction" value="submit">
</form>
</body>
</html>
