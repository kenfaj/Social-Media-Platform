package com.mycompany.webapplicationdb.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import static com.mycompany.webapplicationdb.model.MySQLCredentials.DEFAULT_PASSWORD;
import static com.mycompany.webapplicationdb.model.MySQLCredentials.DEFAULT_PORT;
import static com.mycompany.webapplicationdb.model.MySQLCredentials.DEFAULT_SERVERHOST;
import static com.mycompany.webapplicationdb.model.MySQLCredentials.DEFAULT_USERNAME;

public class JDBCModel {

    private Connection conn;
    private String jdbcUrl;
    private String userName;
    private String password;

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
        userName = USERNAME.isEmpty() ? DEFAULT_USERNAME : USERNAME;
        password = PASSWORD.isEmpty() ? DEFAULT_PASSWORD : PASSWORD;
        jdbcUrl = "jdbc:mysql://" + serverHost + ":" + port + "/" + databaseName
                + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        conn = renewConnection();
    }

    public JDBCModel() {
        this(DATABASE);
    }

    // method to renew connection
    private Connection renewConnection() {
        try {
            if (conn != null) {
                conn.close();
            }
            Connection c = DriverManager.getConnection(jdbcUrl, userName, password);
            // tester
            System.out.println("Successful Databse Connection using: " + jdbcUrl);
            return c;
        } catch (SQLException e) {
            System.out.println("Failed Databse Connection");
            e.printStackTrace();
        }
        throw new UnsupportedOperationException();
    }

    // Method to get a HashMap of Usernames and passwords from Connection
    public Map<String, String> getCredentials() {
        conn = renewConnection();
        Map<String, String> credentials = new HashMap<>();
        String query = "SELECT username, password FROM account";

        try ( Statement stmt = conn.createStatement();  ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                credentials.put(username, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return credentials;
    }

    // Method to get the user_role using username from Connection
    public String getUserRole(String username) {
        conn = renewConnection();
        String role = "";
        String query = "SELECT user_role FROM account WHERE username = '" + username + "'";

        try ( Statement stmt = conn.createStatement();  ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                role = rs.getString("user_role");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return role;
    }

    public static void main(String[] args) {
        new JDBCModel("mp2");
    }
}
