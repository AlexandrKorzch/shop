package com.luxoft.korzch.database.dao;

import com.luxoft.korzch.database.DBConnectionProvider;
import com.luxoft.korzch.database.dao.base.ClientDao;
import com.luxoft.korzch.domain.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.luxoft.korzch.database.DatabaseContract.*;

public class ClientDaoImpl implements ClientDao<Client> {

    private final DBConnectionProvider dbConnectionProvider;

    private static final String createClientCommand = "INSERT INTO " + TABLE_CLIENT + " (" + NAME + ", " + LAST_NAME + ", " + PHONE + ") VALUES (?,?,?)";
    private static final String updateClientCommand = "UPDATE " + TABLE_CLIENT + " SET "+PHONE+" = ?, "+EMAIL+" = ?, "+AGE+" = ? WHERE " + ID + "= ?";
    private static final String getClientCommand = "SELECT * FROM " + TABLE_CLIENT + " WHERE " + ID + " = ?";
    private static final String deleteClientCommand = "DELETE FROM " + TABLE_CLIENT + " WHERE " + ID + "= ?";
    private static final String getAllClientsCommand = "SELECT * FROM " + TABLE_CLIENT;

    public ClientDaoImpl(DBConnectionProvider connection) {
        this.dbConnectionProvider = connection;
    }

    @Override
    public boolean create(Client item) {
        try (Connection connection = dbConnectionProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement(createClientCommand)) {
            statement.setString(1, item.getName());
            statement.setString(2, item.getLastName());
            statement.setString(3, item.getPhone());
            statement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Client get(long id) {
        Client client = null;
        try (Connection connection = dbConnectionProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement(getClientCommand)) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if(resultSet.first()){
                    client = new Client(
                            resultSet.getLong(ID),
                            resultSet.getString(NAME),
                            resultSet.getString(LAST_NAME),
                            resultSet.getInt(AGE),
                            resultSet.getString(PHONE),
                            resultSet.getString(EMAIL));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }

    @Override
    public List<Client> getAll() {
        List<Client> clients = new ArrayList<>();
        try (Connection connection = dbConnectionProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement(getAllClientsCommand);
             ResultSet resultSet = statement.executeQuery()) {
            resultSet.first();
            while (!resultSet.isAfterLast()) {
                clients.add(new Client(
                        resultSet.getLong(ID),
                        resultSet.getString(NAME),
                        resultSet.getString(LAST_NAME),
                        resultSet.getInt(AGE),
                        resultSet.getString(PHONE),
                        resultSet.getString(EMAIL)));
                resultSet.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    @Override
    public boolean update(Client item) {
        try (Connection connection = dbConnectionProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement(updateClientCommand)) {
            statement.setString(1, item.getPhone());
            statement.setString(2, item.getEmail());
            statement.setLong(3, item.getAge());
            statement.setLong(4, item.getId());
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
             PreparedStatement statement = connection.prepareStatement(deleteClientCommand)) {
            statement.setLong(1, id);
            return statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}