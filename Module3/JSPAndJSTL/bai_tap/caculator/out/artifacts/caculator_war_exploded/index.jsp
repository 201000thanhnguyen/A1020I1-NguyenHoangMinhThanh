<%--
  Created by IntelliJ IDEA.
  User: MINH-THANH
  Date: 05/05/2021
  Time: 6:05 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <c:out value="Xin chào" />
  <form action="/CalculatorServlet">
    <label for="tsMot">Tham số thứ nhất</label>
    <input type="number" step="0.01" name="tsMot" id="tsMot" required>
    <br>
    <label for="phepToan">Phép Toán : </label>
    <select name="phepToan" id="phepToan">
      <option value="cong">Cộng</option>
      <option value="tru">Trừ</option>
      <option value="nhan">Nhân</option>
      <option value="chia">Chia</option>
    </select>
    <br>
    <label for="tsHai">Tham số thứ hai</label>
    <input type="number" step="0.01" name="tsHai" id="tsHai" required>
    <br>
    <button type="submit" formmethod="get">calculator</button>
  </form>
  <p>kết quả <c:out value="${tsMot}"/> <c:out value="${phepToan}"/> <c:out value="${tsHai}"/> = <c:out value="${ketQua}"/></p>

  <p>${testHtml}</p>
  <p><c:out value="${testHtml}"/></p>
  </body>
</html>
