<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/_layout/_header.jsp" %>
<%--<jsp:include page="/_layout/_header.jsp"/>--%>
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
                <button class="btn btn-outline-dark float-left">Customer</button>
                <a href="/Customer?action=addCustomer" class="float-right btn btn-outline-primary">add</a>
            </div>
            <table class="table table-striped table-responsive w-100 d-block d-md-table">
                <thead>
                <tr>
                    <th>action</th>
                    <th>no</th>
                    <th>name</th>
                    <th>customer type</th>
                    <th>birthday</th>
                    <th>gender</th>
                    <th>id card</th>
                    <th>phone</th>
                    <th>email</th>
                    <th>address</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="item" items="${listCustomer}" varStatus="no">
                    <tr class="middle-by-mt">
                        <td>
                            <div class="btn-group">
                                <button type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown"
                                        aria-haspopup="true" aria-expanded="false">
                                    Action
                                </button>
                                <div class="dropdown-menu">
                                    <a class="dropdown-item" href="#">detail</a>
                                    <a class="dropdown-item" href="/Customer?action=editCustomer&id=<c:out value="${item.customerId}"/>">edit</a>
                                    <a class="dropdown-item" href="#" onclick="sureDelete(<c:out value="${item.customerId}"/>)">delete</a>
                                </div>
                            </div>
                        </td>
                        <td><c:out value="${no.index + 1}"/></td>
                        <td><c:out value="${item.customerName}"/></td>
                        <td><c:out value="${item.customerTypeName}"/></td>
                        <td><c:out value="${item.customerBirthday}"/></td>
                        <td>
                            <c:choose>
                                <c:when test="${item.customerGender == 0}">
                                    Female
                                </c:when>
                                <c:when test="${item.customerGender == 1}">
                                    Male
                                </c:when>
                                <c:otherwise>
                                    Other
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td><c:out value="${item.customerIdCard}"/></td>
                        <td><c:out value="${item.customerPhone}"/></td>
                        <td><c:out value="${item.customerEmail}"/></td>
                        <td><c:out value="${item.customerAddress}"/></td>
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
                        <a class="page-link" href="/Customer?action=paging&page=<%=i%>"><%=i%></a>
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

<%--<jsp:include page="/_layout/_header.jsp"/>--%>
<%@ include file="/_layout/_footer.jsp" %>