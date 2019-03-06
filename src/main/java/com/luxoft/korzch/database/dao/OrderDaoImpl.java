package com.luxoft.korzch.database.dao;

import com.luxoft.korzch.database.dao.base.OrderDao;
import com.luxoft.korzch.domain.Client;
import com.luxoft.korzch.domain.Order;
import com.luxoft.korzch.domain.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static com.luxoft.korzch.database.DatabaseContract.*;

public class OrderDaoImpl implements OrderDao<Order> {

    private final Connection connection;

    private final String addOrderCommand = "INSERT INTO " + TABLE_CLIENT_ORDER + " (" + CLIENT_ID + ") VALUES (?)";
//    private final String getLastOrderIdCommand = "SELECT MAX(" + ORDER_ID + " FROM " + TABLE_CLIENT_ORDER;
    private final String addOrderDetailsCommand = "INSERT INTO " + TABLE_ORDER_DETAILS + " (" + ORDER_ID + ", " + PRODUCT_ID + ") VALUES (?,?)";

    /*
    insert into CLIENT_ORDER  ( CLIENT_ID  ) values ( 1)
    insert into ORDER_DETAILS (ORDER_ID , PRODUCT_ID ) values ( 1,  2)*/

//    private final String deleteFromBasketCommand = "DELETE FROM " + TABLE_BASKET + " WHERE " + CLIENT_ID + "=? AND " + PRODUCT_ID + "=?";
//    private final String getBasketCommand = "SELECT * FROM " + TABLE_BASKET + " WHERE " + CLIENT_ID + " = ?";


    public OrderDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean create(Order order) {

        try (PreparedStatement statement = connection.prepareStatement(addOrderCommand)) {
            statement.setLong(1, order.getClientId());
            statement.execute();

            try (ResultSet resultSet = statement.getGeneratedKeys()) {
                resultSet.last();
                long orderId = resultSet.getLong(ID);

                try (PreparedStatement detailsStatement = connection.prepareStatement(addOrderDetailsCommand)) {

                    for (Product product : order.getProducts()) {
                        detailsStatement.setLong(1, orderId);
                        detailsStatement.setLong(2, product.getId());
                        detailsStatement.addBatch();
                    }

                    int[] ints = statement.executeBatch();
                    System.out.println(ints);

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Order order) {
        return false;
    }

    @Override
    public Order get(long id) {
        return null;
    }

    @Override
    public List<Order> getAll() {
        return null;
    }

    @Override
    public List<Order> getAllClientOrders(long id) {
        return null;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }
}