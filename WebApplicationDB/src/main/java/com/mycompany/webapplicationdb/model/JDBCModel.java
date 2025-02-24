package com.mycompany.webapplicationdb.model;

import java.sql.Connection;
import java.sql.DriverManager;

import static com.mycompany.webapplicationdb.model.MySQLCredentials.DEFAULT_PASSWORD;
import static com.mycompany.webapplicationdb.model.MySQLCredentials.DEFAULT_PORT;
import static com.mycompany.webapplicationdb.model.MySQLCredentials.DEFAULT_SERVERHOST;
import static com.mycompany.webapplicationdb.model.MySQLCredentials.DEFAULT_USERNAME;

public class JDBCModel {
    private Connection conn;

    // Default dont change, if you want to change values for your database change in
    // MySQLCredentials
    public static final String SERVERHOST = "localhost";
    public static final String DATABASE = "mp2";
    public static final String PORT = "3306";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "1234";

    public JDBCModel(String database) {
        String serverHost = SERVERHOST.isEmpty() ? DEFAULT_SERVERHOST : SERVERHOST;
        String port = PORT.isEmpty() ? DEFAULT_PORT : PORT;
        String databaseName = database.isEmpty() ? DATABASE : database;
        String userName = USERNAME.isEmpty() ? DEFAULT_USERNAME : USERNAME;
        String password = PASSWORD.isEmpty() ? DEFAULT_PASSWORD : PASSWORD;
        
        String jdbcUrl = "jdbc:mysql://" + serverHost + ":" + port + "/" + databaseName + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

        try {
            conn = DriverManager.getConnection(jdbcUrl, userName, password);
            //tester
            System.out.println("Successful Databse Connection using: " + jdbcUrl);
        } catch (Exception e) {
            System.out.println("Failed Databse Connection");
            e.printStackTrace();
        }

        
    }

    public JDBCModel() {
        this(DATABASE);
    }

    public static void main(String[] args) {
        new JDBCModel("mp2");
    }
}