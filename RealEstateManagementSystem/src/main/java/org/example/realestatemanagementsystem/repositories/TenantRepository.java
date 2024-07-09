package org.example.realestatemanagementsystem.repositories;

import org.example.realestatemanagementsystem.data.DBConnection;
import org.example.realestatemanagementsystem.data.DBTenantConstants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TenantRepository {
    public String getTenantFullName(String email) {
        String tenantFullName = "";
        try (Connection connection = DBConnection.dbConnection();
             PreparedStatement prepare = connection.prepareStatement(
                     DBTenantConstants.SELECT_TENANT_NAME)) {
            prepare.setString(1, email);
            try (ResultSet resultSet = prepare.executeQuery()) {
                if (resultSet.next()) {
                    String firstName = resultSet.getString("first_name");
                    String lastName = resultSet.getString("last_name");
                    tenantFullName = firstName + " " + lastName;
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,
                    "An error occurred while fetching tenant full name", e);
        }
        return tenantFullName;
    }

    public String getTenantName(int id) {
        String tenantFullName = "";

        try (Connection connection = DBConnection.dbConnection();
             PreparedStatement prepare = connection.prepareStatement(
                     DBTenantConstants.SELECT_TENANT_NAME_BY_LEASE_CONTRACT)) {
            prepare.setInt(1, id);
            try (ResultSet resultSet = prepare.executeQuery()) {
                if (resultSet.next()) {
                    String firstName = resultSet.getString("first_name");
                    String lastName = resultSet.getString("last_name");
                    tenantFullName = firstName + " " + lastName;
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,
                    "An error occurred while fetching tenant first and last name", e);
        }
        return tenantFullName.trim();
    }

    public int getTenantIdByEmail(String email) {
        int tenantId = -1;
        try (
                Connection connection = DBConnection.dbConnection();
                PreparedStatement prepare = connection.prepareStatement(DBTenantConstants.SELECT_TENANT_ID)) {
            prepare.setString(1, email);
            try (ResultSet resultSet = prepare.executeQuery()) {
                if (resultSet.next()) {
                    tenantId = resultSet.getInt("id");
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,
                    "An error occurred while fetching tenant id by email");
        }
        return tenantId;
    }
}
