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
                addUserPost(request, response);
                break;
            case "editUser":
                editUserPost(request, response);
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
            case "deleteUser":
                deleteUserGet(request, response);
                break;
            case "editUser":
                editUserGet(request, response);
                break;
            case "detailUser":
                detailUserGet(request, response);
                break;
            case "searchCountry":
                searchCountryGet(request, response);
                break;
            case "sortNameASC":
                sortNameASC(request, response);
                break;
            case "sortNameDESC":
                sortNameDESC(request, response);
                break;
            default:
                break;
        }
    }


    protected void redirectHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listUser", this.service.listUser());
        request.getRequestDispatcher("/User/index.jsp").forward(request,response);
    }

    private void addUserPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
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

    private void deleteUserGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        String msg = this.service.deleteUser(id);
        request.setAttribute("msg", msg);
        redirectHome(request, response);
    }

    private void editUserGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        User user = this.service.detailUser(id);
        request.setAttribute("user", user);
        request.getRequestDispatcher("/User/edit.jsp").forward(request,response);
    }

    private void editUserPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        String nameUser = request.getParameter("nameUser");
        String email = request.getParameter("email");
        String country = request.getParameter("country");

        User user = new User(id, nameUser, email, country);
        String msg = this.service.editUser(user);
        request.setAttribute("msg", msg);
        redirectHome(request, response);
    }

    private void detailUserGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        User user = this.service.detailUser(id);
        request.setAttribute("user", user);
        request.getRequestDispatcher("/User/detail.jsp").forward(request,response);
    }

    private void searchCountryGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String country = request.getParameter("country");
        request.setAttribute("listUser", this.service.searchCountry(country));
        request.getRequestDispatcher("/User/index.jsp").forward(request, response);
    }

    private void sortNameASC(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listUser", this.service.sortNameASC());
        request.getRequestDispatcher("/User/index.jsp").forward(request,response);
    }

    private void sortNameDESC(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listUser", this.service.sortNameDESC());
        request.getRequestDispatcher("/User/index.jsp").forward(request,response);
    }
}
