package com.luxoft.korzch.database.dao;

import com.luxoft.korzch.database.dao.base.BasketDao;
import com.luxoft.korzch.domain.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.luxoft.korzch.database.DatabaseContract.*;

public class BasketDaoImpl implements BasketDao {

    private final Connection connection;

    private final String addToBasketCommand = "INSERT INTO " + TABLE_BASKET + " (" + CLIENT_ID + ", " + PRODUCT_ID + ") VALUES (?,?)";
    private final String deleteFromBasketCommand = "DELETE FROM " + TABLE_BASKET + " WHERE " + CLIENT_ID + "=? AND " + PRODUCT_ID + "=?";
    private final String getBasketCommand = "SELECT * FROM " + TABLE_PRODUCT + " JOIN " + TABLE_BASKET + " ON " + ID + "=" + PRODUCT_ID + " WHERE " + CLIENT_ID + " = ?";

    public BasketDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean add(long productId, long clientId) {
        return simpleCommand(productId, clientId, addToBasketCommand);
    }

    @Override
    public List<Product> getAll(long clientId) {
        List<Product> products = new ArrayList<>();
        ResultSet resultSet = null;
        try (PreparedStatement statement = connection.prepareStatement(getBasketCommand)) {
            statement.setLong(1, clientId);
            resultSet = statement.executeQuery();
            resultSet.first();
            while (!resultSet.isAfterLast()) {
                products.add(new Product(
                        resultSet.getLong(ID),
                        resultSet.getString(NAME),
                        resultSet.getDouble(PRICE)));
                resultSet.next();
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public boolean remove(long productId, long clientId) {
        return simpleCommand(productId, clientId, deleteFromBasketCommand);
    }

    private boolean simpleCommand(long productId, long clientId, String deleteFromBasketCommand) {
        try (PreparedStatement statement = connection.prepareStatement(deleteFromBasketCommand)) {
            statement.setLong(1, clientId);
            statement.setLong(2, productId);
            statement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}