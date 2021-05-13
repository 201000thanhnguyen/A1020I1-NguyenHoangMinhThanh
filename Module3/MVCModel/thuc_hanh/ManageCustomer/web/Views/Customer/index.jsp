<%--
  Created by IntelliJ IDEA.
  User: 20100
  Date: 5/10/2021
  Time: 7:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Customer</h1>
<div>
    <h3><c:out value="${msg}"/></h3>
</div>
<div>
    <button><a href="/Controller/Customer?manipulation=addCustomer">add customer</a></button>
</div>
<div>
        <table border="1">
            <tr>
                <th>no</th>
                <th>name customer</th>
                <th>age customer</th>
                <th>gender customer</th>
                <th>avatar customer</th>
                <th colspan="3">Manipulation</th>
            </tr>
            <c:forEach var="item" items="${customers}" varStatus="no" >
                <tr>
                    <td><c:out value="${no.index + 1}"/></td>
                    <td><c:out value="${item.nameCustomer}"/></td>
                    <td><c:out value="${item.ageCustomer}"/></td>
                    <td>
                        <c:choose>
                            <c:when test="${item.genderCustomer == 1}">male</c:when>
                            <c:otherwise>
                                female
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td><c:out value="${item.avatarCustomer}"/></td>
                    <td>1</td>
                    <td>2</td>
                    <td>3</td>
                </tr>
            </c:forEach>
        </table>
</div>
</body>
</html>
