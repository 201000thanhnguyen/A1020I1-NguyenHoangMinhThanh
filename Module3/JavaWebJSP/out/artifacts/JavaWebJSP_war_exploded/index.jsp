<%--
  Created by IntelliJ IDEA.
  User: MINH-THANH
  Date: 28/04/2021
  Time: 8:04 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/abc">
    <input type="submit" value="hello world">
  </form>

  <form action="/datetime">
    <input type="submit" name="dateTimeNow" id="dateTimeNow" value="Get Time Now">
  </form>

  <form action="/login" method="post">
    <p>name: <input type="text" name="name" id="name"></p>
    <p>pass: <input type="password" name="pass" id="pass"></p>
    <input type="submit" name="submit" id="submit" value="submit">
  </form>
  
  </body>
</html>
