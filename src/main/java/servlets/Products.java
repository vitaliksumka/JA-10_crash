package servlets;

import com.google.gson.Gson;
import domain.Product;
import dto.UserLogin;
import service_implementation.ProductService;
import service_implementation.impl.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Products", value = "/Products")
public class Products extends HttpServlet {

    private ProductService productService = ProductServiceImpl.getProductServiceService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Product> productList = productService.readAll();
        String json = new Gson().toJson(productList);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }


}
