package minhthanh.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            double tsMot = Double.parseDouble(request.getParameter("tsMot"));
            double tsHai = Double.parseDouble(request.getParameter("tsHai"));
            double ketQua = 0;

            String testHtml = "<p style=\"color: red\">test kkk</p>";
            String phepToan = request.getParameter("phepToan");

            switch (phepToan) {
                case "cong":
                    ketQua = tsMot + tsHai;
                    phepToan = "+";
                    break;
                case "tru":
                    ketQua = tsMot - tsHai;
                    phepToan = "-";
                    break;
                case "nhan":
                    ketQua = tsMot * tsHai;
                    phepToan = "*";
                    break;
                case "chia":
                    ketQua = tsMot / tsHai;
                    phepToan = "/";
                    break;
                default:
                    break;
            }

            request.setAttribute("tsMot", tsMot);
            request.setAttribute("tsHai", tsHai);
            request.setAttribute("ketQua", ketQua);
            request.setAttribute("phepToan", phepToan);
            request.setAttribute("testHtml", testHtml);

            request.getRequestDispatcher("index.jsp").forward(request,response);
        }catch (Exception e){
            response.sendError(500);
        }
    }
}
