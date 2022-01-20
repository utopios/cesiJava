package com.correction.caisse.tools;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/cesi";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "";

    private static final String DRIVER_STRING = "com.mysql.cj.jdbc.Driver";

    private Connection connection;

    public static Connection getConnection() throws Exception {
        Class.forName(DRIVER_STRING);
        return DriverManager.getConnection(CONNECTION_STRING, DATABASE_USER, DATABASE_PASSWORD);
    }
}
