package Controllers;

import Models.bean.User;
import Models.service.IUserService;
import Models.service.impl.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserServlet", urlPatterns = "/User")
public class UserServlet extends HttpServlet {
    IUserService service = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        if (action == null){
            redirectHome(request, response);
        }
        switch (action){
            case "addUser":
                addUserController(request, response);
                break;
            default:
                break;
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null){
            redirectHome(request, response);
        }
        switch (action){
            case "addUser":
                response.sendRedirect("/User/add.jsp");
                break;
            default:
                break;
        }
    }

    protected void redirectHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listUser", this.service.listUser());
        request.getRequestDispatcher("/User/index.jsp").forward(request,response);
    }

    private void addUserController(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String nameUser = request.getParameter("nameUser");
        String email = request.getParameter("email");
        String country = request.getParameter("country");

        User user = new User();
        user.setNameUser(nameUser);
        user.setEmail(email);
        user.setCountry(country);

        String msg =  this.service.addUser(user);

        request.setAttribute("msg", msg);
        redirectHome(request, response);
    }
}
