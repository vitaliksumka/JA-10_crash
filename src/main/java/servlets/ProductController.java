package servlets;

import domain.Product;
import service_implementation.ProductService;
import service_implementation.impl.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/product")
public class ProductController extends HttpServlet {

    ProductService productService = ProductServiceImpl.getProductServiceService();

    // CRUD:
    // to create resources (product)
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String prodName = request.getParameter("productName");
        String prodDescription = request.getParameter("productDescription");
        String prodPrice = request.getParameter("productPrice");

        Product product = new Product(prodName, prodDescription, getValidatedPrice(prodPrice));

        productService.create(product);

        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("Success");


    }

    private double getValidatedPrice(String price){
            if(price == null || price.isEmpty()){
                return 0;
            }
            return Double.parseDouble(price);
    }

    // to get resources (product)
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String productId = request.getParameter("id");
       Product product = productService.read(Integer.parseInt(productId));


       request.setAttribute("product", product);
       request.getRequestDispatcher("/singleProduct.jsp").forward(request, response);

    }

    // to update resources (product)
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    // to delete resources (product)
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
