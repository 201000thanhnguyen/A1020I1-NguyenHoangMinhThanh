<%--
  Created by IntelliJ IDEA.
  User: 20100
  Date: 5/12/2021
  Time: 9:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <div>
        <h2>
            <a href="/User">Home</a>
        </h2>
    </div>
    <h3>add user</h3>
    <div>
        <form action="/User?action=addUser" method="post">
            <label for="nameUser">name user : </label>
            <input type="text" name="nameUser" id="nameUser"><br>
            <label for="email">email : </label>
            <input type="email" name="email" id="email"><br>
            <label for="country">country : </label>
            <input type="text" name="country" id="country"><br>

            <input type="submit" name="submit" id="submit" value="submit">
        </form>
    </div>
</div>
</body>
</html>
