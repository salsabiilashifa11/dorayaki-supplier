package com.wbd.dorayakisupplier.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RequestLogRepository {

    private final Connection dbConnection;

    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public RequestLogRepository(Connection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public void createRequestLog(String ipAddress, String endpoint) {
        try {
            Statement stmt = dbConnection.createStatement();
            String query = "INSERT INTO request_logs (ip_address, endpoint, created_at, updated_at) " +
                    "VALUES ('" + ipAddress + "', '" + endpoint + "', NOW(), NOW())";
            stmt.executeUpdate(query);
            stmt.close();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Request log creation failed with error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public int countRequest(String ipAddress, String endpoint, int seconds) {
        Integer count = -1; // Error value

        try {
            Statement stmt = dbConnection.createStatement();
            String query = "SELECT COUNT(*) AS \"count\" FROM request_logs" +
                    " WHERE ip_address = '" + ipAddress +
                    "' AND endpoint = '" + endpoint +
                    "' AND created_at > (NOW() - interval '" + seconds + " seconds')";

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                count = rs.getInt("count");
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Request log count failed with " + e.getMessage());
            e.printStackTrace();
        }

        return count;
    }
}
