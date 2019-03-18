package com.luxoft.korzch.database.dao;

import com.luxoft.korzch.database.DBConnectionProvider;
import com.luxoft.korzch.database.dao.base.OrderDao;
import com.luxoft.korzch.domain.Order;
import com.luxoft.korzch.domain.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.luxoft.korzch.database.DatabaseContract.*;

public class OrderDaoImpl implements OrderDao<Order> {

    private final DBConnectionProvider dbConnectionProvider;

    private static final String addOrderCommand = "INSERT INTO " + TABLE_CLIENT_ORDER + " (" + CLIENT_ID + ") VALUES (?)";
    private static final String getLastOrderIdCommand = "SELECT MAX(" + ID + ") FROM " + TABLE_CLIENT_ORDER;
    private static final String addOrderDetailsCommand = "INSERT INTO " + TABLE_ORDER_DETAILS + " (" + ORDER_ID + ", " + PRODUCT_ID + ") VALUES (?,?)";

    private static final String getClientOrders = "SELECT * FROM " + TABLE_CLIENT_ORDER + " WHERE " + CLIENT_ID + " = ?";
    private static final String getProductsInOrder = "SELECT " + ID + ", " + NAME + ", " + PRICE + " FROM " + TABLE_PRODUCT + " P" + " JOIN " + TABLE_ORDER_DETAILS + " D on P." + ID + "= D." + PRODUCT_ID + " WHERE D." + ORDER_ID + " = ?";

    public OrderDaoImpl(DBConnectionProvider connection) {
        this.dbConnectionProvider = connection;
    }

    @Override
    public boolean create(Order order) {

        try (Connection connection = dbConnectionProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement(addOrderCommand);
             PreparedStatement statementLastId = connection.prepareStatement(getLastOrderIdCommand);
             PreparedStatement detailsStatement = connection.prepareStatement(addOrderDetailsCommand)) {
            statement.setLong(1, order.getClientId());
            statement.execute();
            ResultSet resultSet = statementLastId.executeQuery();
            if (resultSet.first()) {
                long orderId = resultSet.getLong(1);
                for (Product product : order.getProducts()) {
                    detailsStatement.setLong(1, orderId);
                    detailsStatement.setLong(2, product.getId());
                    detailsStatement.addBatch();
                }
                detailsStatement.executeBatch();
                return true;
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Order> getAllClientOrders(long clientId) {
        List<Order> orders = new ArrayList<>();
        try (Connection connection = dbConnectionProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement(getClientOrders);
             PreparedStatement statementProducts = connection.prepareStatement(getProductsInOrder)) {
            statement.setLong(1, clientId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.first()) {
                while (!resultSet.isAfterLast()) {
                    long orderId = resultSet.getLong(1);
                    Order order = new Order();
                    order.setId(resultSet.getLong(ID));
                    order.setClientId(resultSet.getLong(CLIENT_ID));

                    statementProducts.setLong(1, orderId);
                    List<Product> products = new ArrayList<>();
                    ResultSet resultSetProducts = statementProducts.executeQuery();
                    resultSetProducts.first();
                    while (!resultSetProducts.isAfterLast()) {
                        long productId = resultSetProducts.getLong(ID);
                        String name = resultSetProducts.getString(NAME);
                        double price = resultSetProducts.getDouble(PRICE);
                        Product product = new Product(productId, name, price);
                        products.add(product);
                        resultSetProducts.next();
                    }
                    resultSetProducts.close();
                    order.setProducts(products);
                    orders.add(order);
                    resultSet.next();
                }
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public Order get(long id) {
        return null;
    }

    @Override
    public boolean update(Order order) {
        return false;
    }

    @Override
    public List<Order> getAll() {
        return null;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }
}