package controllers;

import models.bean.RentType;
import models.bean.Service;
import models.bean.ServiceType;
import models.service.IRentTypeService;
import models.service.IServiceService;
import models.service.IServiceTypeService;
import models.service.impl.RentTypeService;
import models.service.impl.ServiceService;
import models.service.impl.ServiceTypeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServiceServlet", urlPatterns = "/Service")
public class ServiceServlet extends HttpServlet {
    IRentTypeService rentTypeService = new RentTypeService();
    IServiceTypeService serviceTypeService = new ServiceTypeService();
    IServiceService serviceService = new ServiceService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        if (action == null){
            redirectService(request,response);
            return;
        }
        switch (action){
            case "addVilla":
            case "addHouse":
            case "addRoom":
                addServicePost(request, response);
                break;
            default:
                redirectService(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null){
            redirectService(request, response);
            return;
        }
        switch (action){
            case "addVilla":
            case "addHouse":
            case "addRoom":
                redirectAddService(request, response, action);
                break;
            default:
                redirectService(request,response);
                break;
        }
    }

    private void redirectAddService(HttpServletRequest request, HttpServletResponse response, String action) throws ServletException, IOException {
        List<RentType> rentType = this.rentTypeService.listInService();
        request.setAttribute("rentType", rentType);
        request.setAttribute("action", action);
        request.setAttribute("serviceTypeId", request.getParameter("serviceTypeId"));
        request.getRequestDispatcher("/Views/Service/add.jsp").forward(request,response);
    }

    private void redirectService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Service> listService = this.serviceService.listInService();
        List<ServiceType> listServiceType = this.serviceTypeService.listInService();
        request.setAttribute("listService", listService);
        request.setAttribute("listServiceType", listServiceType);
        request.getRequestDispatcher("/Views/Service/index.jsp").forward(request,response);
    }

    private void addServicePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String serviceName = request.getParameter("serviceName");
            int serviceArea = Integer.parseInt(request.getParameter("serviceArea"));
            int rentTypeId = Integer.parseInt(request.getParameter("rentTypeId"));
            List<RentType> rentTypeList = this.rentTypeService.listInService();
            double serviceCost = rentTypeList.get(rentTypeId).getRentTypeCost();
            int serviceMaxPeople = Integer.parseInt(request.getParameter("serviceMaxPeople"));
            int serviceTypeId = Integer.parseInt(request.getParameter("serviceTypeId"));

            int numberOfFloors;
            String descOtherConvenience;
            String standardRoom;

            if (request.getParameter("action").equals("addRoom")){
                standardRoom = null;
                descOtherConvenience = null;
                numberOfFloors = 0;
            }else {
                standardRoom = request.getParameter("standardRoom");
                descOtherConvenience = request.getParameter("descOtherConvenience");
                numberOfFloors = Integer.parseInt(request.getParameter("numberOfFloors"));
            }

            double poolArea;
            if (!request.getParameter("action").equals("addVilla")){
                poolArea = 0.0;
            }else {
                poolArea = Double.parseDouble(request.getParameter("poolArea"));
            }


            Service service = new Service(
                serviceName,
                    serviceArea,
                    serviceCost,
                    serviceMaxPeople,
                    rentTypeId,
                    serviceTypeId,
                    standardRoom,
                    descOtherConvenience,
                    poolArea,
                    numberOfFloors
            );

            String msg = this.serviceService.addInService(service);
            request.setAttribute("msg", msg);
            redirectService(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}











