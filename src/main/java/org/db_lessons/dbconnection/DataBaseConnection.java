package org.db_lessons.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DataBaseConnection {
    private final static String URL = "jdbc:mysql://localhost:3306/homework";
    private final static String USER = "root";
    private final static String PASSWORD = "thebloodcoon";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public static Connection getConnection() {
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
