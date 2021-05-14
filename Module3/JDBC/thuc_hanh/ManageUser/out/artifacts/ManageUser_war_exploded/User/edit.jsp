
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <h2>
        <a href="/User">Home</a>
    </h2>
</div>
<div>
    <h3>edit user</h3>
</div>
<div>
    <form action="/User?action=editUser&id=<c:out value="${user.id}"/>" method="post">
        <label for="nameUser">name user : </label>
        <input type="text" name="nameUser" id="nameUser" value="<c:out value="${user.nameUser}"/>"><br>
        <label for="email">email : </label>
        <input type="email" name="email" id="email" value="<c:out value="${user.email}"/>"><br>
        <label for="country">country : </label>
        <input type="text" name="country" id="country" value="<c:out value="${user.country}"/>"><br>

        <button type="submit">submit</button>
    </form>
</div>
</body>
</html>
