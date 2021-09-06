package dao.impl;

import dao.BucketDAO;
import domain.Bucket;
import utils.ConnectionUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BucketDaoImpl implements BucketDAO {

    private static String READ_ALL = "select * from bucket";
    private static String CREATE = "insert into bucket(`user_id`, `product_id`, `purchase_date`) values (?,?,?)";
    private static String READ_BY_ID = "select * from bucket where id =?";
    private static String DELETE_BY_ID = "delete from bucket where id=?";

    private Connection connection;
    private PreparedStatement preparedStatement;

    public BucketDaoImpl() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        connection = ConnectionUtils.openConnection();
    }

    @Override
    public Bucket create(Bucket bucket) {
        try {
            preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, bucket.getUserId());
            preparedStatement.setInt(2, bucket.getProductId());
            preparedStatement.setDate(3, (java.sql.Date) new Date(bucket.getPurchaseDate().getTime()));
            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            rs.next();
            bucket.setId(rs.getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bucket;
    }

    @Override
    public Bucket read(Integer id) {
        Bucket bucket = null;
        try {
            preparedStatement = connection.prepareStatement(READ_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();
            result.next();

            Integer bucketId = result.getInt("id");
            Integer userId = result.getInt("user_id");
            Integer productId = result.getInt("product_id");
            java.util.Date purchaseDate = result.getDate("purchase_date");

            bucket = new Bucket(bucketId, userId, productId, purchaseDate);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bucket;
    }

    @Override
    public Bucket update(Bucket t) {
        throw new IllegalStateException("there is no update for bucket");
    }

    @Override
    public void delete(Integer id) {
        try {
            preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Bucket> readAll() {

        List<Bucket> bucketRecords = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(READ_ALL);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                Integer bucketId = result.getInt("id");
                Integer userId = result.getInt("user_id");
                Integer productId = result.getInt("product_id");
                java.util.Date purchaseDate = result.getDate("purchase_date");
                bucketRecords.add(new Bucket(bucketId, userId, productId, purchaseDate));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bucketRecords;
    }
}

