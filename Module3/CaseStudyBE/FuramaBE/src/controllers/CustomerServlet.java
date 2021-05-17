package controllers;

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

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null){
            request.setAttribute("customerService", this.customerService.listInService());
            redirectCustomer(request, response);
        }

        switch (action){
            case "add":
                response.sendRedirect("/Views/Customer/add.jsp");
                break;
            default:
                redirectCustomer(request, response);
                break;
        }
    }

    private void redirectCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Views/Customer/index.jsp").forward(request, response);
    }
}
