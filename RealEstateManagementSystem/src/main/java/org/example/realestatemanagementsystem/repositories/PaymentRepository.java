package org.example.realestatemanagementsystem.repositories;

import org.example.realestatemanagementsystem.data.DBConnection;
import org.example.realestatemanagementsystem.data.DBPropertyConstants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PaymentRepository {
    public String getPropertyAddressForPayments(int leaseContractId) {
        String property = "";

        try (Connection connection = DBConnection.dbConnection();
             PreparedStatement prepare = connection.prepareStatement(
                     DBPropertyConstants.SELECT_ADDRESS_BY_PAYMENT_AND_CONTRACT)) {
            prepare.setInt(1, leaseContractId);
            try (ResultSet resultSet = prepare.executeQuery()) {
                if (resultSet.next()) {
                    property = resultSet.getString("address");
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,
                    "An error occurred while fetching property address for payments", e);
        }
        return property;
    }
}
