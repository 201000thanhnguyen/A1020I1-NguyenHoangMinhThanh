package controllers;

import models.bean.Customer;
import models.service.ICustomerService;
import models.service.ICustomerTypeService;
import models.service.impl.CustomerService;
import models.service.impl.CustomerTypeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/Customer")
public class CustomerServlet extends HttpServlet {
    ICustomerTypeService customerTypeService = new CustomerTypeService();
    ICustomerService customerService = new CustomerService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        if (action == null) {
            redirectCustomer(request,response);
            return;
        }else {
            switch (action) {
                case "addCustomer":
                    addCustomerPost(request,response);
                    break;
                default:
                    redirectCustomer(request,response);
                    break;
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
//            request.setAttribute("listCustomer", this.customerService.listInService());
            redirectCustomer(request, response);
//            pagingCustomer(request,response);
            return;
        }

        switch (action) {
            case "addCustomer":
                addCustomerGet(request,response);
                break;
            case "paging":
                pagingCustomer(request,response);
                break;
            case "deleteCustomer":
                deleteCustomerGet(request,response);
                break;
            case "editCustomer":
                editCustomerGet(request,response);
                break;
            default:
                redirectCustomer(request, response);
                break;
        }
    }

    private void redirectCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int numberPage;
        int countCustomer = this.customerService.countInService();
        double countCustomerBeta = Double.parseDouble(String.valueOf(countCustomer));
        double numberPageBeta = countCustomerBeta/10;
        numberPage = (int) Math.ceil(numberPageBeta);
        request.setAttribute("numberPage",numberPage);
        request.setAttribute("listCustomer", this.customerService.listLimitInService(0,10));
        request.getRequestDispatcher("/Views/Customer/index.jsp").forward(request, response);
    }

    private void addCustomerGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("customerType", this.customerTypeService.listInService());
        request.getRequestDispatcher("/Views/Customer/add.jsp").forward(request, response);
    }


    private void addCustomerPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String msg = null;
        try {
            Customer customer = new Customer();
            customer.setCustomerTypeId(Integer.parseInt(request.getParameter("customerTypeId")));
            customer.setCustomerName(request.getParameter("customerName"));
            customer.setCustomerBirthday(request.getParameter("customerBirthday"));
            customer.setCustomerGender(Integer.parseInt(request.getParameter("customerGender")));
            customer.setCustomerIdCard(request.getParameter("customerIdCard"));
            customer.setCustomerPhone(request.getParameter("customerPhone"));
            customer.setCustomerEmail(request.getParameter("customerEmail"));
            customer.setCustomerAddress(request.getParameter("customerAddress"));

            msg = this.customerService.addInService(customer);
        }catch (Exception e){
            e.printStackTrace();
            msg = e.toString();
        }

        request.setAttribute("msg", msg);
        pagingCustomer(request,response);
    }

    private void pagingCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            int numberPage;
            String page = request.getParameter("page");
            int countCustomer = this.customerService.countInService();
            double countCustomerBeta = Double.parseDouble(String.valueOf(countCustomer));
            double numberPageBeta = countCustomerBeta/10;
            numberPage = (int) Math.ceil(numberPageBeta);
            request.setAttribute("numberPage",numberPage);
            if (page == null){
                request.setAttribute("listCustomer", this.customerService.listLimitInService(0,10));
                request.getRequestDispatcher("/Views/Customer/index.jsp").forward(request,response);
            }else {
                int numberOfPage = Integer.parseInt(page);
                request.setAttribute("listCustomer", this.customerService.listLimitInService((numberOfPage-1)*10,10));
                request.getRequestDispatcher("/Views/Customer/index.jsp").forward(request,response);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void deleteCustomerGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String msg;
        try {
            int customerId = Integer.parseInt(request.getParameter("id"));
            msg = this.customerService.deleteInService(customerId);
        }catch (Exception e){
            msg = e.toString();
        }
        request.setAttribute("msg", msg);
        redirectCustomer(request,response);
    }

    private void editCustomerGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            int customerId = Integer.parseInt(request.getParameter("id"));
            Customer customer = this.customerService.detailInService(customerId);
            request.setAttribute("customer",customer);
            request.setAttribute("customerType",this.customerTypeService.listInService());
            request.getRequestDispatcher("/Views/Customer/edit.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
