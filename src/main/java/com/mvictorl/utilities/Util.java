package com.mvictorl.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by mvictorl on 7/11/17.
 */
public class Util {

    private static final String DB_DRIVER = "org.mariadb.jdbc.Driver";
    private static final String DB_URL = "jdbc:mariadb://localhost:3306/RomanBrovkoJDBC_Test";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "";

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("SQL Connection READY...");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Connection FAIL...");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL FAIL...");
        }
        return connection;
    }
}
