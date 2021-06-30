<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: 20100
  Date: 6/12/2021
  Time: 10:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<ul>
    <c:forEach var="item" items="${sandwichList}">
        <li>
            <c:forEach var="item1" items="${item.condimentSet}">
                ${item1.toString()},
            </c:forEach>
        </li>
    </c:forEach>
</ul>

<form:form modelAttribute="sandwich" action="/Sandwich/add" method="post">
    <form:checkboxes path="condimentSet" items="${sandwichCondiment}"/>
    <button type="submit">submit</button>
</form:form>

</body>
</html>
