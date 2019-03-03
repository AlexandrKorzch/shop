package com.luxoft.korzch.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TablesCRUDIml implements TablesCRUD {

    private final Connection connection;

    public TablesCRUDIml(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void createClientTable() {
        String client = "create table if not exists client (" +
                "id bigint auto_increment not null, " +
                "age integer, " +
                "name varchar(15), " +
                "lastName varchar(15), " +
                "email varchar(25), " +
                "phone varchar(15), " +
                "primary key (id))";
        executeCommand(client);
    }

    @Override
    public void createProductTable() {
        String product = "create table if not exists product (" +
                "id bigint auto_increment not null, " +
                "name varchar(25), " +
                "price float, " +
                "primary key (id))";
        executeCommand(product);
    }

    @Override
    public void createBasketTable() {
        String basket = "create table if not exists basket (" +
                "client_id bigint not null, " +
                "product_id bigint not null, " +
                "count integer default 1, " +
                "foreign key (client_id) " +
                "references client(id)," +
                "foreign key (product_id) references product(id))";
        executeCommand(basket);
    }

    @Override
    public void createOrderTable() {
        String clientOrder = "create table if not exists client_order(" +
                "id bigint auto_increment not null, " +
                "client_id bigint not null, " +
                "foreign key (client_id) references client(id))";
        executeCommand(clientOrder);

        String clientOrders = "create table if not exists client_orders(" +
                "order_id bigint not null, " +
                "product_id bigint not null, " +
                "foreign key (order_id) references client_order(id), " +
                "foreign key (product_id) references product(id))";
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