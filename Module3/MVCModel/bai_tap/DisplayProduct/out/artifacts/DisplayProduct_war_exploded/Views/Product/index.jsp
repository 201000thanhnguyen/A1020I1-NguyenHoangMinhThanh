<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>${msg}</h3>
<a href="/product/ListProduct">product</a>
<div>
    <a href="/product/ListProduct?manipulation=add">
        <button>add product</button>
    </a>
</div>
<table border="1">
    <tr>
        <th>no</th>
        <th>name product</th>
        <th>price product</th>
        <th>image product</th>
        <th colspan="3">manipulation</th>
    </tr>
    <c:forEach var="item" items="${listProduct}" varStatus="no">
        <tr>
            <td><c:out value="${no.index + 1}"/></td>
            <td><c:out value="${item.nameProduct}"/></td>
            <td><c:out value="${item.priceProduct}"/></td>
            <td>
                <img src="${pageContext.request.contextPath}${item.imgProduct}" style="width: 30px;" alt="">
            </td>
            <td>
                <a href="/product/ListProduct?id=<c:out value="${no.index}"/>&manipulation=detail">
                    <button>detail</button>
                </a>
            </td>
            <td>
                <a href="/product/ListProduct?id=<c:out value="${no.index}"/>&manipulation=edit">
                    <button>edit</button>
                </a>
            </td>
            <td>
                <button onclick="sure(<c:out value="${no.index}"/>)">delete</button>
            </td>
        </tr>
    </c:forEach>

    <script>
        function sure(index) {
            if(confirm("are you sure")){
                location.href = '/product/ListProduct?id='+index+'&manipulation=delete';
            }
        }
    </script>
</table>
</body>
</html>
