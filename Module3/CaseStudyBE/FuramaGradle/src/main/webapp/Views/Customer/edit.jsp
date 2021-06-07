<%@ include file="/_layout/_header.jsp" %>

<div class="row">
    <div class="col-md-12">
        <div class="card">
            <div class="card-header">
                Edit Customer
            </div>
            <div class="card-body py-3">
                <form action="/Customer?action=editCustomer&id=<c:out value="${customer.customerId}"/>" method="post">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label for="customerName">Customer Name</label>
                                        <input type="text" class="form-control" id="customerName" name="customerName"
                                               value="<c:out value="${customer.customerName}"/>">
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label for="customerTypeId">Customer Type</label>
                                        <select class="custom-select" id="customerTypeId" name="customerTypeId">
                                            <option value="<c:out value="${customer.customerTypeId}"/>">
                                                <c:out value="${customer.customerTypeName}"/>
                                            </option>
                                            <c:forEach var="item" items="${customerType}">
                                                <c:if test="${item.customerTypeId != customer.customerTypeId}">
                                                    <option value="<c:out value="${item.customerTypeId}"/>">
                                                        <c:out value="${item.customerTypeName}"/>
                                                    </option>
                                                </c:if>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label for="customerBirthday">Customer Birthday</label>
                                        <input type="date" class="form-control" name="customerBirthday"
                                               id="customerBirthday"
                                               value="<c:out value="${customer.customerBirthday}"/>">
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label for="customerGender">Customer Gender</label>
                                        <select class="custom-select" id="customerGender" name="customerGender">
                                            <c:choose>
                                                <c:when test="${customer.customerGender == 1}">
                                                    <option value="1">Male</option>
                                                    <option value="0">Female</option>
                                                </c:when>
                                                <c:otherwise>
                                                    <option value="0">Female</option>
                                                    <option value="1">Male</option>
                                                </c:otherwise>
                                            </c:choose>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label for="customerIdCard">Id Card</label>
                                        <input type="text" class="form-control" id="customerIdCard"
                                               name="customerIdCard"
                                               value="<c:out value="${customer.customerIdCard}"/>">
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label for="customerPhone">Customer Phone</label>
                                        <input type="text" class="form-control" id="customerPhone"
                                               name="customerPhone" value="<c:out value="${customer.customerPhone}"/>">
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label for="customerEmail">Customer Email</label>
                                        <input type="email" class="form-control" id="customerEmail" name="customerEmail"
                                               value="<c:out value="${customer.customerEmail}"/>">
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label for="customerAddress">Customer Address</label>
                                        <input type="text" class="form-control" id="customerAddress"
                                               name="customerAddress"
                                               value="<c:out value="${customer.customerAddress}"/>">
                                    </div>
                                </div>
                            </div>
                        </div>
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
