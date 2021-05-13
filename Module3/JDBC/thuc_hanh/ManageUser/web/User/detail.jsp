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
    <h3>detail</h3>
</div>
<div>
    <table border="1">
        <tr>
            <th>name user</th>
            <th>email</th>
            <th>country</th>
            <th colspan="2">
                action
            </th>
        </tr>
        <tr>
            <td><c:out value="${user.nameUser}"/></td>
            <td><c:out value="${user.email}"/></td>
            <td><c:out value="${user.country}"/></td>
            <td>
                <button>
                    <a href="/User?action=editUser&id=<c:out value="${user.id}"/>">edit</a>
                </button>
            </td>
            <td>
                <button onclick="sureDelete(<c:out value="${user.id}"/>)">delete</button>
            </td>
        </tr>
    </table>
    <script>
        function sureDelete(id){
            if (confirm("Are you sure you want to delete this data?")){
                location.href = "/User?action=deleteUser&id="+id;
            }
        }
    </script>
</div>
</body>
</html>
