package com.wbd.dorayakisupplier.repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnector {

    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://database-3.cqjy1ve55cev.ap-southeast-1.rds.amazonaws.com/postgres";
            String username = "postgres";
            String password = "postgres";

            connection = DriverManager.getConnection(url, username, password);

            if (connection != null) {
                LOGGER.log(Level.INFO, "Connection Success!");
            } else {
                LOGGER.log(Level.WARNING, "Connection Failed!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }

    public static void closeConnection(Connection conn) {
        try {
            LOGGER.log(Level.INFO, "Connection closed successfully!");
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
