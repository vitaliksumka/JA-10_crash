package servlets;

import com.google.gson.Gson;
import domain.Bucket;
import domain.Product;
import dto.BucketDto;
import service_implementation.BucketService;
import service_implementation.ProductService;
import service_implementation.impl.BucketServiceImpl;
import service_implementation.impl.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@WebServlet("/buckets")
public class BucketsController2 extends HttpServlet {

    private	BucketService bucketService = BucketServiceImpl.getBucketService();
    private ProductService productService = ProductServiceImpl.getProductServiceService();


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Bucket> buckets = bucketService.readAll();
        Map<Integer, Product> idToProduct = productService.readAllMap();
        List<BucketDto> listOfBucketDtos = map(buckets, idToProduct);

        String json = new Gson().toJson(listOfBucketDtos);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }


    public List<BucketDto> map(List<Bucket> buckets, Map<Integer, Product> idToProduct){

        return	buckets.stream().map(bucket->{
            BucketDto bucketDto = new BucketDto();
            bucketDto.bucketId = bucket.getId();
            bucketDto.purchaseDate = bucket.getPurchaseDate();

            Product product = idToProduct.get(bucket.getProductId());
            bucketDto.name = product.getName();
            bucketDto.description = product.getDescription();
            bucketDto.price = product.getPrice();

            return bucketDto;
        }).collect(Collectors.toList());

    }
}