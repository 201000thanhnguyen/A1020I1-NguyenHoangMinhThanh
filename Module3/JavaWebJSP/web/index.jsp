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
    <input type="submit" value="ok">
  </form>
  <h2><%=request.getAttribute("hello")%></h2>
  </body>
</html>
