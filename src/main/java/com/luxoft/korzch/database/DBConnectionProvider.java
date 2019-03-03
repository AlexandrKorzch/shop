package com.luxoft.korzch.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionProvider {

    //todo set your database properties
    private static final String DATABASE_PATH = "/home/alex/IdeaProjects/shop/src/main/database";
    private static final String DATABASE_JAR = "/h2-1.4.197.jar";
    private static final String DATABASE_NAME = "/shop";

    private static final String DATABASE_URL = "jdbc:h2:tcp://localhost/~/" + DATABASE_PATH + DATABASE_NAME;
    private static final String DATABASE_USER_NAME = "ALEX";
    private static final String DATABASE_PASSWORD = "";

    private Connection connection;

    public DBConnectionProvider() {
        startDataBase();
        connectToDatabase();
    }

    public Connection getConnection() {
        return connection;
    }

    private void startDataBase() {
        try {
            ProcessBuilder processBuilder =
                    new ProcessBuilder("xterm", "-e", "java -jar " + DATABASE_PATH + DATABASE_JAR);
            processBuilder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void connectToDatabase() {
        try {
            this.connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER_NAME, DATABASE_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}