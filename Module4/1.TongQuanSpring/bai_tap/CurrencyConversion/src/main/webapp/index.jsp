<%--
  Created by IntelliJ IDEA.
  User: 20100
  Date: 6/11/2021
  Time: 5:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h3>usd to vnd</h3>
<form action="/home/index" method="get">
    <label for="usd"> usd : </label>
    <input type="number" name="usd" step="0.01" id="usd"><br>
    <label for="vnd"> vnd : </label>
    <input type="number" name="vnd" step="0.01" id="vnd" readonly value="${vnd}"><br>
    <input type="submit" name="submit" id="submit" value="submit">
</form>
</body>
</html>
