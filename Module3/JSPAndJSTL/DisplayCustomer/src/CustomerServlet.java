import Customers.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/CustomerServlet")
public class CustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer("cus1", "2000-11-20", "Hà Nội", "/Images/noAvatar.jpg"));
        customerList.add(new Customer("cus1", "2003-09-11", "Đà Nẵng", "/Images/noAvatar.jpg"));
        customerList.add(new Customer("cus1", "2004-01-04", "Hồ Chí Minh", "/Images/noAvatar.jpg"));

        request.setAttribute("customerList", customerList);
        request.getRequestDispatcher("/Views/Customer.jsp").forward(request,response);
    }
}
