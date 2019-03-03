package com.luxoft.korzch.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static com.luxoft.korzch.database.DatabaseContract.*;

public class TablesCRUDIml implements TablesCRUD {

    private final Connection connection;

    public TablesCRUDIml(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void createClientTable() {
        String client = "create table if not exists "+TABLE_CLIENT+" (" +
                ID+" bigint auto_increment not null, " +
                AGE+" integer, " +
                NAME+" varchar(15), " +
                LAST_NAME+" varchar(15), " +
                EMAIL+" varchar(25), " +
                PHONE+" varchar(15), " +
                "primary key ("+ID+"))";
        executeCommand(client);
    }

    @Override
    public void createProductTable() {
        String product = "create table if not exists "+TABLE_PRODUCT+" (" +
                ID+" bigint auto_increment not null, " +
                NAME+" varchar(25), " +
                PRICE+" float, " +
                "primary key ("+ID+"))";
        executeCommand(product);
    }

    @Override
    public void createBasketTable() {
        String basket = "create table if not exists "+TABLE_BASKET+" (" +
                CLIENT_ID+" bigint not null, " +
                PRODUCT_ID+" bigint not null, " +
                COUNT+" integer default 1, " +
                "foreign key ("+CLIENT_ID+") references "+TABLE_CLIENT+"("+ID+")," +
                "foreign key ("+PRODUCT_ID+") references "+TABLE_PRODUCT+"("+ID+"))";
        executeCommand(basket);
    }

    @Override
    public void createOrderTable() {
        String clientOrder = "create table if not exists "+TABLE_CLIENT_ORDER+"(" +
                ID+" bigint auto_increment not null, " +
                CLIENT_ID+" bigint not null, " +
                "foreign key ("+CLIENT_ID+") references "+TABLE_CLIENT+"("+ID+"))";
        executeCommand(clientOrder);

        String clientOrders = "create table if not exists "+TABLE_CLIENT_ORDERS+"(" +
                ORDER_ID+" bigint not null, " +
                PRODUCT_ID+" bigint not null, " +
                "foreign key ("+ORDER_ID+") references "+TABLE_CLIENT_ORDER+"("+ID+"), " +
                "foreign key ("+PRODUCT_ID+") references "+TABLE_PRODUCT+"("+ID+"))";
        executeCommand(clientOrders);
    }

    private void executeCommand(String command) {
        try (Statement statement = connection.createStatement()) {
            statement.execute(command);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}