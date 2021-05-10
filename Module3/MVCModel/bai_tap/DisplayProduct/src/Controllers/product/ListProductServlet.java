package Controllers.product;

import Models.bean.Product;
import Models.service.IProductService;
import Models.service.impl.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "ListProductServlet", urlPatterns = "/product/ListProduct")
public class ListProductServlet extends HttpServlet {

    IProductService productService = new ProductService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String manipulation = request.getParameter("manipulation");
        if (manipulation.equals("edit")){
            String idProduct = request.getParameter("idProduct");
            String nameProduct = request.getParameter("nameProduct");
            Double priceProduct = Double.parseDouble(request.getParameter("priceProduct"));
            String imgProduct = "/Images/noAvatar.jpg";
            String msg = productService.editProduct(idProduct, nameProduct, priceProduct, imgProduct);

            request.setAttribute("msg", msg);
            request.setAttribute("listProduct", productService.listProduct());
            redirectHome(request,response);
        }else if (manipulation.equals("add")){
            String idProduct = UUID.randomUUID().toString();
            String nameProduct = request.getParameter("nameProduct");
            Double priceProduct = Double.parseDouble(request.getParameter("priceProduct"));
            String imgProduct = "/Images/noAvatar.jpg";
            String msg = productService.addProduct(new Product(idProduct, nameProduct, priceProduct, imgProduct));

            request.setAttribute("msg", msg);
            request.setAttribute("listProduct", productService.listProduct());
            redirectHome(request,response);
        }else {
            response.sendError(500);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String manipulation = request.getParameter("manipulation");
        String index = request.getParameter("id");
        if (manipulation == null && index == null){
            request.setAttribute("listProduct", productService.listProduct());
            redirectHome(request,response);
        }else if (manipulation.equals("detail")){
            int indexProduct = Integer.parseInt(index);
            request.setAttribute("detailProduct", productService.listProduct().get(indexProduct));
            request.getRequestDispatcher("/Views/Product/detail.jsp").forward(request,response);
        }else if (manipulation.equals("edit")){
            int indexProduct = Integer.parseInt(index);
            request.setAttribute("detailProduct", productService.listProduct().get(indexProduct));
            request.getRequestDispatcher("/Views/Product/edit.jsp").forward(request,response);
        }else if (manipulation.equals("add")){
            request.getRequestDispatcher("/Views/Product/add.jsp").forward(request,response);
        }else if (manipulation.equals("delete")){
            int indexProduct = Integer.parseInt(index);
            String msg = productService.deleteProduct(indexProduct);
            request.setAttribute("msg", msg);
            request.setAttribute("listProduct", productService.listProduct());
            request.getRequestDispatcher("/Views/Product/index.jsp").forward(request,response);
        }else {
            response.sendError(404);
        }
    }

    private void redirectHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.getRequestDispatcher("/Views/Product/index.jsp").forward(request,response);
    }
}
