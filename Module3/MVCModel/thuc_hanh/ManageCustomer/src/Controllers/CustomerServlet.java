package Controllers;

import Models.Bean.Customer;
import Models.Service.ICustomerService;
import Models.Service.impl.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "CustomerServlet", urlPatterns = "/Controller/Customer")
public class CustomerServlet extends HttpServlet {

    ICustomerService service = new CustomerService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        try {
            String manipulation = request.getParameter("manipulation");
            if (manipulation.equals("addCustomer")){
                String id = UUID.randomUUID().toString();
                String nameCustomer = request.getParameter("nameCustomer");
                int ageCustomer = Integer.parseInt(request.getParameter("ageCustomer"));
                int genderCustomer = Integer.parseInt(request.getParameter("genderCustomer"));
                String avatarCustomer = request.getParameter("avatarCustomer");
                Customer customer = new Customer(id, nameCustomer, ageCustomer, genderCustomer, avatarCustomer);
                String msg = service.addCustomer(customer);
                request.setAttribute("msg", msg);
                redirectHome(request,response);
            }else {

            }
        }catch (Exception e){
            request.setAttribute("msg", e);
            redirectHome(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String manipulation = request.getParameter("manipulation");
            String idCustomer = request.getParameter("idCustomer");
            if (manipulation == null && idCustomer == null){
                request.setAttribute("customers", service.listCustomer());
                redirectHome(request,response);
            }else if (manipulation.equals("addCustomer")){
                request.getRequestDispatcher("/Views/Customer/add.jsp").forward(request,response);
            }else {

            }
        }catch (Exception e){
            request.setAttribute("msg", e);
            redirectHome(request, response);
        }
    }

    public void redirectHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Views/Customer/index.jsp").forward(request, response);
    }
}
