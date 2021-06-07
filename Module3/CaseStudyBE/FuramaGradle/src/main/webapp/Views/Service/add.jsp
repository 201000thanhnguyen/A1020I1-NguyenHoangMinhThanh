<%@ include file="/_layout/_header.jsp" %>

<div class="row">
    <div class="col-md-12">
        <div class="card">
            <div class="card-header">
                Add Service
            </div>
            <div class="card-body py-3">
                <form action="/Service?action=<c:out value="${action}"/>" method="post">
                    <div class="row">
                        <div class="col-md-<c:if test='${action != "addRoom"}'>6</c:if><c:if test='${action == "addRoom"}'>12</c:if>">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label for="serviceName">Service Name</label>
                                        <input type="text" class="form-control" id="serviceName" name="serviceName">
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label for="serviceArea">Area</label>
                                        <input type="number" min="0" class="form-control" id="serviceArea"
                                               name="serviceArea">
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label for="serviceMaxPeople">Max People</label>
                                        <input type="number" min="1" class="form-control" id="serviceMaxPeople"
                                               name="serviceMaxPeople">
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label for="rentTypeId">Rent Type</label>
                                        <select class="custom-select" id="rentTypeId" name="rentTypeId">
                                            <c:forEach var="item" items="${rentType}">
                                                <option value="<c:out value="${item.rentTypeId - 1}"/>">
                                                    <c:out value="${item.rentTypeName}"/>
                                                </option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <c:if test='${action != "addRoom"}'>
                            <div class="col-md-6">
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label for="standardRoom">Standard Room</label>
                                            <input type="text" class="form-control" id="standardRoom"
                                                   name="standardRoom">
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label for="descOtherConvenience">Description</label>
                                            <input type="text" class="form-control" id="descOtherConvenience"
                                                   name="descOtherConvenience">
                                        </div>
                                    </div>
                                    <c:if test='${action == "addVilla"}'>
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label for="poolArea">Pool Area</label>
                                                <input type="number" step="0.01" class="form-control" id="poolArea"
                                                       name="poolArea">
                                            </div>
                                        </div>
                                    </c:if>
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label for="numberOfFloors">Number Floors</label>
                                            <input type="number" min="0" class="form-control" id="numberOfFloors"
                                                   name="numberOfFloors">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:if>
                        <input type="hidden" name="serviceTypeId" id="serviceTypeId"
                               value="<c:out value="${serviceTypeId}"/>">
                        <div class="col-md-12">
                            <button type="submit" class="btn btn-primary">Submit</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<%@ include file="/_layout/_footer.jsp" %>