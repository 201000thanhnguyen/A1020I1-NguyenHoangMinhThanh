<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/_layout/_header.jsp" %>

<div class="row">
    <div class="col-md-12">
        <div class="card">
            <div class="card-header">
                Ground
            </div>
            <table class="table table-striped table-responsive w-100 d-block d-md-table">
                <thead>
                <tr>
                    <th>action</th>
                    <th>ground Id</th>
                    <th>ground Status Name</th>
                    <th>ground Acreage</th>
                    <th>ground Floor</th>
                    <th>ground Type Name</th>
                    <th>ground Cost</th>
                    <th>ground Start Date</th>
                    <th>ground End Date</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="item" items="${listGround}">
                    <tr>
                        <td>
                            <div class="btn-group">
                                <button type="button" class="btn btn-secondary dropdown-toggle"
                                        data-toggle="dropdown"
                                        aria-haspopup="true" aria-expanded="false">
                                    Action
                                </button>
                                <div class="dropdown-menu">
                                    <a class="dropdown-item"
                                       href="/Ground?action=detailGround&id=${item.groundId}">detail</a>
                                    <a class="dropdown-item"
                                       href="/Ground?action=editGround&id=${item.groundId}">edit</a>
                                    <a class="dropdown-item"
                                       href="/Ground?action=deleteGround&id=${item.groundId}">delete</a>
                                </div>
                            </div>
                        </td>
                        <td><c:out value="${item.groundId}"/></td>
                        <td><c:out value="${item.groundStatusName}"/></td>
                        <td><c:out value="${item.groundAcreage}"/></td>
                        <td><c:out value="${item.groundFloor}"/></td>
                        <td><c:out value="${item.groundTypeName}"/></td>
                        <td><c:out value="${item.groundCost}"/></td>
                        <td><c:out value="${item.groundStartDate}"/></td>
                        <td><c:out value="${item.groundEndDate}"/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>


<%@ include file="/_layout/_footer.jsp" %>