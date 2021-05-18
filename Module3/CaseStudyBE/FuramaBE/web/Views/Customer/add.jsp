<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/_layout/_header.jsp" %>

<%
    String test1 = "12/10/2020";
    String test2 = null;
    SimpleDateFormat inSDF = new SimpleDateFormat("mm/dd/yyyy");
    SimpleDateFormat outSDF = new SimpleDateFormat("yyyy-mm-dd");
    Date date = inSDF.parse("11/10/2020");
    test2 = outSDF.format(date);
    System.out.println(test2);
%>

<div class="row">
    <div class="col-md-12">
        private int customerId;
        private int customerTypeId;
        private String customerTypeName;
        private String customerName;
        private String customerBirthday;
        private int customerGender;
        private String customerIdCard;
        private String customerPhone;
        private String customerEmail;
        private String customerAddress;
        <div class="card">
            <div class="card-header">
                Add Customer
            </div>
            <div class="card-body py-3">
                <form>
                  <div class="row">
                    <div class="col-md-6">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="form-group">
                                    <label for="">Customer Name</label>
                                    <input type="text" class="form-control" id="">
                                </div>
                            </div>
                            <div class="col-md-12">
                                <div class="form-group">
                                    <label for="">Customer Type</label>
                                    <select class="custom-select">
                                      <option value="1">One</option>
                                      <option value="2">Two</option>
                                      <option value="3">Three</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-md-12">
                                <div class="form-group">
                                    <label for="">Customer Birthday</label>
                                    <input type="date" class="form-control" id="">
                                </div>
                            </div>
                            <div class="col-md-12">
                                <div class="form-group">
                                    <label for="">Customer Gender</label>
                                    <select class="custom-select">
                                      <option value="1">One</option>
                                      <option value="2">Two</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="exampleInputPassword1">Password</label>
                            <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                        </div>
                    </div>
                    <div class="col-md-12">
                        <button type="submit" class="btn btn-primary">Login</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</div>

<%@ include file="/_layout/_footer.jsp" %>