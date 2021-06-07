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
                <a href="/Service" class="btn btn-outline-dark float-left">Service</a>
                <div class="btn-group float-right dropleft">
                    <button type="button" class="btn btn-outline-primary dropdown-toggle"
                            data-toggle="dropdown"
                            aria-haspopup="true" aria-expanded="false">
                        Add
                    </button>
                    <div class="dropdown-menu">
                        <c:forEach var="item" items="${listServiceType}">
                            <a class="dropdown-item" href="/Service?action=add<c:out value="${item.serviceTypeName}"/>&serviceTypeId=<c:out value="${item.serviceTypeId}"/>">
                                <c:out value="${item.serviceTypeName}"/>
                            </a>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <table class="table table-striped table-responsive w-100 d-block d-md-table">
                <thead>
                <tr>
                    <th>no</th>
                    <th>Name</th>
                    <th>Area</th>
                    <th>Cost</th>
                    <th>Max People</th>
                    <th>Rent Type Name</th>
<%--                    <th>Rent Cost</th>--%>
                    <th>Service Type Name</th>
                    <th>Standard Room</th>
                    <th>Description</th>
                    <th>Pool Area</th>
                    <th>Number Of Floors</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="item" items="${listService}" varStatus="no">
                    <tr>
                        <td><c:out value="${no.index + 1}"/></td>
                        <td><c:out value="${item.serviceName}"/></td>
                        <td><c:out value="${item.serviceArea}"/></td>
                        <td><c:out value="${item.serviceCost}"/></td>
                        <td><c:out value="${item.serviceMaxPeople}"/></td>
                        <td><c:out value="${item.rentTypeName}"/></td>
<%--                        <td><c:out value="${item.rentTypeCost}"/></td>--%>
                        <td><c:out value="${item.serviceTypeName}"/></td>
                        <td><c:out value="${item.standardRoom}"/></td>
                        <td><c:out value="${item.descOtherConvenience}"/></td>
                        <td><c:out value="${item.poolArea}"/></td>
                        <td><c:out value="${item.numberOfFloors}"/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<%--<jsp:include page="/_layout/_header.jsp"/>--%>
<%@ include file="/_layout/_footer.jsp" %>