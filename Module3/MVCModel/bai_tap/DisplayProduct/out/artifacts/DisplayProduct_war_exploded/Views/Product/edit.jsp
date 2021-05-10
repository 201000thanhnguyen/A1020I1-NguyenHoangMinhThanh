<%--
  Created by IntelliJ IDEA.
  User: MINH-THANH
  Date: 08/05/2021
  Time: 1:27 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/product/ListProduct">product</a>
<form action="/product/ListProduct?manipulation=edit" method="post">
    <input type="text" name="idProduct" id="idProduct" value="${detailProduct.idProduct}" style="display: none">
    <label for="nameProduct">name product : </label>
    <input type="text" name="nameProduct" id="nameProduct" value="${detailProduct.nameProduct}"><br>
    <label for="priceProduct">price product : </label>
    <input type="number" step="0.01" name="priceProduct" id="priceProduct" value="${detailProduct.priceProduct}"><br>
    <label for="imgProduct">image product : </label>
    <input type="text" name="imgProduct" id="imgProduct" value="${detailProduct.imgProduct}"><br>

    <input type="submit" name="submit" id="submit" value="submit">
</form>
</body>
</html>
