<%--
  Created by IntelliJ IDEA.
  User: MINH-THANH
  Date: 08/05/2021
  Time: 2:02 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/product/ListProduct">product</a>
<form action="/product/ListProduct?manipulation=add" method="post">
        <label for="nameProduct">name product : </label>
        <input type="text" name="nameProduct" id="nameProduct"><br>
        <label for="priceProduct">price product : </label>
        <input type="number" step="0.01" name="priceProduct" id="priceProduct"><br>
        <label for="imgProduct">image product : </label>
        <input type="text" name="imgProduct" id="imgProduct"><br>

        <input type="submit" name="submit" id="submit" value="submit">
</form>
</body>
</html>
