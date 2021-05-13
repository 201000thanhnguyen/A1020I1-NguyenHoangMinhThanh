<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <h2>user</h2>
</div>
<div>
    <div>
        <h3><c:out value="${msg}"/></h3>
    </div>
    <button>
        <a href="/User?action=addUser">add user</a>
    </button>
    <table border="1">
        <tr>
            <th>no</th>
            <th>name user</th>
            <th>email</th>
            <th>country</th>
            <th colspan="3">action</th>
        </tr>
        <c:forEach var="item" items="${listUser}" varStatus="no" >
            <tr>
                <td><c:out value="${no.index + 1}"/></td>
                <td><c:out value="${item.nameUser}"/></td>
                <td><c:out value="${item.email}"/></td>
                <td><c:out value="${item.country}"/></td>
                <td>
                    <button>
                        <a href="/User?action=detailUser&id=<c:out value="${item.id}"/>">detail</a>
                    </button>
                </td>
                <td>
                    <button>
                        <a href="/User?action=editUser&id=<c:out value="${item.id}"/>">edit</a>
                    </button>
                </td>
                <td>
                    <button onclick="sureDelete(<c:out value="${item.id}"/>)">delete</button>
                </td>
            </tr>
        </c:forEach>
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
