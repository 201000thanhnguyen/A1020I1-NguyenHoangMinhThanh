<%@ include file="/_layout/_header.jsp" %>
<div class="row">
    <c:if test="${msg != null}">
        <div class="col-md-12">
            <div class="alert alert-success alert-dismissible" role="alert">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                    <span class="sr-only">Close</span>
                </button>
                <strong>message : </strong> <c:out value="${msg}"/>
            </div>
        </div>
    </c:if>
    <div class="col-md-12">
        <div class="card">
            <div class="card-header">
                <a href="/Employee" class="btn btn-outline-dark float-left">Employee</a>
                <a href="/Employee?action=addEmployee" class="float-left btn btn-outline-primary ml-2">add</a>
                <form class="form-inline float-right">
                    <div class="form-group">
                        <input type="hidden" name="action" id="action" value="searchEmployee">
                        <input type="text" class="form-control" name="EmployeeName" id="EmployeeName"
                               placeholder="Name . . .">
                    </div>
                    <button type="submit" class="btn btn-outline-primary ml-2">Search</button>
                </form>
            </div>
            <table class="table table-striped table-responsive w-100 d-block d-md-table">
                <thead>
                <tr>
                    <th class="pl-3">action</th>
                    <th>no</th>
                    <th>name</th>
                    <th>birthday</th>
                    <th>id card</th>
                    <th>salary</th>
                    <th>phone</th>
                    <th>email</th>
                    <th>address</th>
                    <th>position</th>
                    <th>education</th>
                    <th>division</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="item" items="${listEmployee}" varStatus="no">
                    <tr class="middle-by-mt">
                        <td>
                            <div class="btn-group">
                                <button type="button" class="btn btn-outline-secondary dropdown-toggle"
                                        data-toggle="dropdown"
                                        aria-haspopup="true" aria-expanded="false">
                                    Action
                                </button>
                                <div class="dropdown-menu">
                                    <a class="dropdown-item"
                                       href="/Employee?action=detailEmployee&id=<c:out value="${item.employeeId}"/>">detail</a>
                                    <a class="dropdown-item"
                                       href="/Employee?action=editEmployee&id=<c:out value="${item.employeeId}"/>">edit</a>
                                    <a class="dropdown-item" href="#"
                                       onclick="sureDelete(<c:out value="${item.employeeId}"/>)">delete</a>
                                </div>
                            </div>
                        </td>
                        <td><c:out value="${no.index + 1}"/></td>
                        <td><c:out value="${item.employeeName}"/></td>
                        <td><c:out value="${item.employeeBirthday}"/></td>
                        <td><c:out value="${item.employeeIdCard}"/></td>
                        <td><c:out value="${item.employeeSalary}"/></td>
                        <td><c:out value="${item.employeePhone}"/></td>
                        <td><c:out value="${item.employeeEmail}"/></td>
                        <td><c:out value="${item.employeeAddress}"/></td>
                        <td><c:out value="${item.positionName}"/></td>
                        <td><c:out value="${item.educationDegreeName}"/></td>
                        <td><c:out value="${item.divisionName}"/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <nav aria-label="Page navigation example" class="mr-3">
                <ul class="pagination justify-content-end">
                    <li class="page-item">
                        <a class="page-link" href="#">Previous</a>
                    </li>
                    <% int numberPage = (int) request.getAttribute("numberPage");
                        for (int i = 1; i <= numberPage; i++) {%>
                    <li class="page-item">
                        <a class="page-link" href="/Employee?action=paging&page=<%=i%>"><%=i%>
                        </a>
                    </li>
                    <% } %>
                    <li class="page-item">
                        <a class="page-link" href="#">Next</a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</div>
<%@ include file="/_layout/_footer.jsp" %>