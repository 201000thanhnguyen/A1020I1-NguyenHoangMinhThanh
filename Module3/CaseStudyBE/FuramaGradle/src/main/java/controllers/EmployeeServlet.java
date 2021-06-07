package controllers;

import models.repository.IEducationDegreeRepository;
import models.repository.impl.EducationDegreeRepository;
import models.service.IDivisionService;
import models.service.IEmployeeService;
import models.service.IPositionService;
import models.service.impl.DivisionService;
import models.service.impl.EmployeeService;
import models.service.impl.PositionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/Employee")
public class EmployeeServlet extends HttpServlet {
    IPositionService positionService = new PositionService();
    IEducationDegreeRepository educationDegreeRepository = new EducationDegreeRepository();
    IDivisionService divisionService = new DivisionService();
    IEmployeeService employeeService = new EmployeeService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            redirectEmployee(request, response);
            return;
        }
        switch (action){
            case "add":
                System.out.println("add");
                break;
            default:
                redirectEmployee(request,response);
                break;
        }
    }

    private void redirectEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int numberPage;
            int countEmployee = this.employeeService.countInService();
            double countEmployeeBeta = Double.parseDouble(String.valueOf(countEmployee));
            double numberPageBeta = countEmployeeBeta / 10;
            numberPage = (int) Math.ceil(numberPageBeta);
            request.setAttribute("numberPage", numberPage);

            request.setAttribute("listPosition", this.positionService.listInService());
            request.setAttribute("listEducationDegree", this.educationDegreeRepository.listInRepository());
            request.setAttribute("listDivision", this.divisionService.listInService());
            String page = request.getParameter("page");
            if (page == null){
                request.setAttribute("listEmployee", this.employeeService.listLimitInService(0, 10));
            }else {
                int numberOfPage = Integer.parseInt(page);
                request.setAttribute("listEmployee", this.employeeService.listLimitInService((numberOfPage - 1) * 10, 10));
            }
            request.getRequestDispatcher("/Views/Employee/index.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
