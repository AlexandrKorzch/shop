package com.luxoft.korzch.database.dao;

import com.luxoft.korzch.database.dao.base.ProductDao;
import com.luxoft.korzch.domain.Client;
import com.luxoft.korzch.domain.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.luxoft.korzch.database.DatabaseContract.*;
import static com.luxoft.korzch.database.DatabaseContract.TABLE_PRODUCT;

public class ProductDaoImpl implements ProductDao<Product> {

    private final Connection connection;

    private final String updateProductCommand = "UPDATE " + TABLE_PRODUCT + " SET "+NAME+" = ?, "+PRICE+" = ? WHERE " + ID + "= ?";
    private final String createProductCommand = "INSERT INTO " + TABLE_PRODUCT + " (" + NAME + ", " + PRICE + ") VALUES (?,?)";
    private final String getProductCommand = "SELECT * FROM " + TABLE_PRODUCT + " WHERE " + ID + " = ?";
    private final String deleteProductCommand = "DELETE FROM " + TABLE_PRODUCT + " WHERE " + ID + "=?";
    private final String getAllProductsCommand = "SELECT * FROM " + TABLE_PRODUCT;

    public ProductDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Product item) {
        try (PreparedStatement statement = connection.prepareStatement(createProductCommand)) {
            statement.setString(1, item.getName());
            statement.setDouble(2, item.getPrice());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product get(long id) {
        Product product = null;
        try (PreparedStatement statement = connection.prepareStatement(getProductCommand)) {
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
        try (PreparedStatement statement = connection.prepareStatement(getAllProductsCommand);
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
    public void update(Product item) {
        try (PreparedStatement statement = connection.prepareStatement(updateProductCommand)) {
            statement.setString(1, item.getName());
            statement.setDouble(2, item.getPrice());
            statement.setLong(3, item.getId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(long id) {
        try (PreparedStatement statement = connection.prepareStatement(deleteProductCommand)) {
            statement.setLong(1, id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
