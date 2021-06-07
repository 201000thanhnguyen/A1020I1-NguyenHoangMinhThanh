package controllers;

import models.service.IGroundService;
import models.service.impl.GroundService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GroundServlet", urlPatterns = "/Ground")
public class GroundServlet extends HttpServlet {
    IGroundService groundService = new GroundService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        if (action == null) {
            redirectHome(request, response);
        } else {
            switch (action) {
                case "action1":
                    System.out.println("action");
                    break;
                default:
                    redirectHome(request, response);
                    break;
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            redirectHome(request, response);
            return;
        }

        switch (action) {
            case "deleteGround":
                deleteGroundGet(request,response);
                break;
            default:
                redirectHome(request, response);
                break;
        }
    }

    private void redirectHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listGround", this.groundService.listInService());
        request.getRequestDispatcher("/Views/Ground/index.jsp").forward(request,response);
    }

    private void deleteGroundGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String msg = this.groundService.deleteInService(id);
        redirectHome(request,response);
    }
}
