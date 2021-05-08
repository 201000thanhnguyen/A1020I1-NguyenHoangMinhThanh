package controllers;

import models.bean.Transaction;
import models.service.ITransactionService;
import models.service.ipml.TransactionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TransactionServlet", urlPatterns = "/transaction")
public class TransactionServlet extends HttpServlet {

    ITransactionService transactionService = new TransactionService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nameTransaction = request.getParameter("nameTransaction");
        Double amountTransaction = Double.parseDouble(request.getParameter("amountTransaction"));
        Transaction transaction = new Transaction(nameTransaction, amountTransaction, "/Images/traibong.jpg");
        transactionService.addTransaction(transaction);
        redirectList(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String create = request.getParameter("create");

        if (create == null){
            redirectList(request,response);
        }

        if (create.equals("create")){
            response.sendRedirect("/Views/Transaction/create.jsp");
        }
    }

    private void redirectList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listTransaction", transactionService.transactionList());
        request.getRequestDispatcher("/Views/Transaction/index.jsp").forward(request, response);
    }
}
