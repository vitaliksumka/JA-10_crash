package service_implementation.impl;

import dao.ProductDAO;
import dao.impl.ProductDaoImpl;
import domain.Product;
import org.apache.log4j.Logger;
import service_implementation.ProductService;
import shared.AbstractCRUD;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService {

    private ProductDAO productDAO;

    private static ProductServiceImpl productService;

    private static Logger logger = Logger.getLogger(ProductServiceImpl.class);

    public ProductServiceImpl() {

        try {
            productDAO = new ProductDaoImpl();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            logger.error(e);
        }

    }

    public static ProductService getProductServiceService() {
        if (productService == null) {
            productService = new ProductServiceImpl();
        }
        return productService;
    }

    @Override
    public Product create(Product product) {
        return productDAO.create(product);
    }

    @Override
    public Product read(Integer id) {
        return productDAO.read(id);
    }

    @Override
    public Product update(Product product) {
        return productDAO.update(product);
    }

    @Override
    public void delete(Integer id) {
        productDAO.delete(id);
    }

    @Override
    public List<Product> readAll() {
        return productDAO.readAll();
    }

    @Override
    public Map<Integer, Product> readAllMap() {
        return  readAll().stream().collect(Collectors.toMap(Product::getId, Function.identity()));
    }
}
