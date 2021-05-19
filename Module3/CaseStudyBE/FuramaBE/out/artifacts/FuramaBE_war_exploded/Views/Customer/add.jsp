
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/_layout/_header.jsp" %>

<div class="row">
    <div class="col-md-12">
        <div class="card">
            <div class="card-header">
                Add Customer
            </div>
            <div class="card-body py-3">
                <form action="/Customer?action=addCustomer" method="post">
                  <div class="row">
                    <div class="col-md-6">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="form-group">
                                    <label for="customerName">Customer Name</label>
                                    <input type="text" class="form-control" id="customerName" name="customerName">
                                </div>
                            </div>
                            <div class="col-md-12">
                                <div class="form-group">
                                    <label for="customerTypeId">Customer Type</label>
                                    <select class="custom-select" id="customerTypeId" name="customerTypeId">
                                        <c:forEach var="item" items="${customerType}" >
                                        <option value="<c:out value="${item.customerTypeId}"/>">
                                        <c:out value="${item.customerTypeName}"/>
                                    </option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="form-group">
                            <label for="customerBirthday">Customer Birthday</label>
                            <input type="date" class="form-control" name="customerBirthday" id="customerBirthday">
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="form-group">
                            <label for="customerGender">Customer Gender</label>
                            <select class="custom-select" id="customerGender" name="customerGender">
                              <option value="1">Male</option>
                              <option value="0">Female</option>
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
                        <input type="text" class="form-control" id="customerIdCard" name="customerIdCard">
                    </div>
                </div>
                <div class="col-md-12">
                    <div class="form-group">
                        <label for="customerPhone">Customer Phone</label>
                        <input type="text" class="form-control" id="customerPhone" name="customerPhone">
                    </div>
                </div>
                <div class="col-md-12">
                    <div class="form-group">
                        <label for="customerEmail">Customer Email</label>
                        <input type="email" class="form-control" id="customerEmail" name="customerEmail" placeholder="example@gmail.com">
                    </div>
                </div>
                <div class="col-md-12">
                    <div class="form-group">
                        <label for="customerAddress">Customer Address</label>
                        <input type="text" class="form-control" id="customerAddress" name="customerAddress" placeholder="Pennsylvania – Washington DC">
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