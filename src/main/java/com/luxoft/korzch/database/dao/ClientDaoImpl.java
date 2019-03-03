package com.luxoft.korzch.database.dao;

import com.luxoft.korzch.database.dao.base.ClientDao;
import com.luxoft.korzch.domain.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static com.luxoft.korzch.database.DatabaseContract.*;

public class ClientDaoImpl<T extends Client> implements ClientDao<T> {

    private final Connection connection;
    String createClientCommand = "INSERT INTO " + TABLE_CLIENT + " (" + NAME + ", " + LAST_NAME + ", " + PHONE + ") VALUES (?,?,?)";
    String getClientCommand = "SELECT * FROM " + TABLE_CLIENT + " where " + ID + " = ?";

    public ClientDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(T item) {
        try (PreparedStatement statement = connection.prepareStatement(createClientCommand);) {
            statement.setString(1, item.getName());
            statement.setString(2, item.getLastName());
            statement.setString(3, item.getPhone());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public T get(long id) {
        Client client = null;
        try (PreparedStatement statement = connection.prepareStatement(getClientCommand)) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                resultSet.first();
                client = new  Client(
                        resultSet.getLong(ID),
                        resultSet.getString(NAME),
                        resultSet.getString(LAST_NAME),
                        resultSet.getInt(AGE),
                        resultSet.getString(PHONE),
                        resultSet.getString(EMAIL));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  (T)client;
    }

    @Override
    public List<T> getAll() {
        return null;
    }

    @Override
    public void update(T item) {

    }

    @Override
    public void delete(long id) {

    }
}