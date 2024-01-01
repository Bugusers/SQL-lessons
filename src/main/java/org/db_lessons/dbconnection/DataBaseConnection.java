package org.db_lessons.dbconnection;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataBaseConnection {
    private final String URL;
    private final String USER;
    private final String PASSWORD;


    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public DataBaseConnection(String url, String user, String password) throws SQLException{
        this.URL = url;
        this.PASSWORD = password;
        this.USER = user;
    }

    public Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void close(Connection connection) throws Exception {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
