package com.luxoft.korzch.database.dao;

import com.luxoft.korzch.database.DBConnectionProvider;
import com.luxoft.korzch.database.dao.base.ProductDao;
import com.luxoft.korzch.domain.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.luxoft.korzch.database.DatabaseContract.*;

public class ProductDaoImpl implements ProductDao<Product> {

    private final DBConnectionProvider dbConnectionProvider;

    private static final String updateProductCommand = "UPDATE " + TABLE_PRODUCT + " SET " + NAME + " = ?, " + PRICE + " = ? WHERE " + ID + "= ?";
    private static final String createProductCommand = "INSERT INTO " + TABLE_PRODUCT + " (" + NAME + ", " + PRICE + ") VALUES (?,?)";
    private static final String getProductCommand = "SELECT * FROM " + TABLE_PRODUCT + " WHERE " + ID + " = ?";
    private static final String deleteProductCommand = "DELETE FROM " + TABLE_PRODUCT + " WHERE " + ID + " =?";
    private static final String getAllProductsCommand = "SELECT * FROM " + TABLE_PRODUCT;

    public ProductDaoImpl(DBConnectionProvider connection) {
        this.dbConnectionProvider = connection;
    }

    @Override
    public boolean create(Product item) {
        try (Connection connection = dbConnectionProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement(createProductCommand)) {
            statement.setString(1, item.getName());
            statement.setDouble(2, item.getPrice());
            statement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Product get(long id) {
        Product product = null;
        try (Connection connection = dbConnectionProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement(getProductCommand)) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                resultSet.first();
                product = new Product(
                        resultSet.getLong(ID),
                        resultSet.getString(NAME),
                        resultSet.getDouble(PRICE));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = dbConnectionProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement(getAllProductsCommand);
             ResultSet resultSet = statement.executeQuery()) {
            resultSet.first();
            while (!resultSet.isAfterLast()) {
                products.add(new Product(
                        resultSet.getLong(ID),
                        resultSet.getString(NAME),
                        resultSet.getDouble(PRICE)));
                resultSet.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public boolean update(Product item) {
        try (Connection connection = dbConnectionProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement(updateProductCommand)) {
            statement.setString(1, item.getName());
            statement.setDouble(2, item.getPrice());
            statement.setLong(3, item.getId());
            statement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(long id) {
        try (Connection connection = dbConnectionProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement(deleteProductCommand)) {
            statement.setLong(1, id);
            return statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
