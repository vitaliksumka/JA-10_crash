package service_implementation.impl;

import dao.ProductDAO;
import dao.impl.ProductDaoImpl;
import domain.Product;
import shared.AbstractCRUD;

import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl implements AbstractCRUD<Product> {

    private ProductDAO productDAO;

    public ProductServiceImpl() {

        try {
            productDAO = new ProductDaoImpl();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

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
}
