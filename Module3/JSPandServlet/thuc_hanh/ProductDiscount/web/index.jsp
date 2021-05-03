<%--
  Created by IntelliJ IDEA.
  User: MINH-THANH
  Date: 30/04/2021
  Time: 10:51 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h2>Product Discount Calculator</h2>
  <form method="post" action="/display-discount">
    <label>Description: </label><br/>
    <input type="text" name="description" placeholder="description"/><br/>
    <label>Price: </label><br/>
    <input type="number" name="price" min="0" value="0"/><br/>
    <label>Discount Percent: </label><br/>
    <input type="number" name="discount" min="0" value="0"/><br/>
    <input type = "submit" id="submit" value="calculator"/>
  </form>

  <table border="1">
    <tr>
      <th>description</th>
      <th>price</th>
      <th>discount</th>
      <th>amount</th>
      <th>thenPrice</th>
    </tr>
    <tr>
      <td><%=request.getAttribute("description")%></td>
      <td><%=request.getAttribute("price")%></td>
      <td><%=request.getAttribute("discount")%></td>
      <td><%=request.getAttribute("amount")%></td>
      <td><%=request.getAttribute("thenPrice")%></td>
    </tr>
  </table>
  </body>
</html>
