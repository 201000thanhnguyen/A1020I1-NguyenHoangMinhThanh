<%--
  Created by IntelliJ IDEA.
  User: MINH-THANH
  Date: 08/05/2021
  Time: 12:14 CH
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
    <table border="1">
        <tr>
            <th>name product</th>
            <th>price product</th>
            <th>image product</th>
        </tr>
        <tr>
            <td><c:out value="${detailProduct.nameProduct}"/></td>
            <td><c:out value="${detailProduct.priceProduct}"/></td>
            <td><c:out value="${detailProduct.imgProduct}"/></td>
        </tr>
    </table>
</body>
</html>
