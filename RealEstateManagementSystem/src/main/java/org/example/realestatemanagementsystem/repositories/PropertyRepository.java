package org.example.realestatemanagementsystem.repositories;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.realestatemanagementsystem.data.DBConnection;
import org.example.realestatemanagementsystem.data.DBPropertyConstants;

import java.sql.*;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PropertyRepository {
    public String getPropertyType(int propertyId) {
        String propertyType = "";

        try (Connection connection = DBConnection.dbConnection();
             PreparedStatement prepare = connection.prepareStatement(
                     DBPropertyConstants.SELECT_TYPE)) {
            prepare.setInt(1, propertyId);
            try (ResultSet resultSet = prepare.executeQuery()) {
                if (resultSet.next()) {
                    propertyType = resultSet.getString("type");
                }
            }

        } catch (SQLException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,
                    "An error occurred while fetching property type", e);
        }
        return propertyType;
    }

    public String getPropertyAmenities(int propertyId) {
        String propertyAmenities = "";

        try (Connection connection = DBConnection.dbConnection();
             PreparedStatement prepare = connection.prepareStatement(
                     DBPropertyConstants.SELECT_AMENITIES)) {
            prepare.setInt(1, propertyId);
            try (ResultSet resultSet = prepare.executeQuery()) {
                if (resultSet.next()) {
                    propertyAmenities = resultSet.getString("amenities");
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,
                    "An error occurred while fetching property amenities", e);
        }
        return propertyAmenities;
    }

    public String getPropertyWithContract(int propertyId) {
        String property = "";

        try (Connection connection = DBConnection.dbConnection();
             PreparedStatement prepare = connection.prepareStatement(
                     DBPropertyConstants.SELECT_ADDRESS_BY_LEASE_CONTRACTS)) {
            prepare.setInt(1, propertyId);
            try (ResultSet resultSet = prepare.executeQuery()) {
                if (resultSet.next()) {
                    property = resultSet.getString("address");
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,
                    "An error occurred while fetching property with lease contract", e);
        }
        return property;
    }

    public String getPropertyAddress(int propertyId) {
        String propertyAddress = null;

        try (Connection connect = DBConnection.dbConnection();
             PreparedStatement prepare = connect.prepareStatement(
                     DBPropertyConstants.SELECT_ADDRESS)) {

            prepare.setInt(1, propertyId);

            try (ResultSet resultSet = prepare.executeQuery()) {
                if (resultSet.next()) {
                    propertyAddress = resultSet.getString("address");
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,
                    "An error occurred while fetching property address", e);
        }
        return propertyAddress;
    }

    public int getPropertyIdByAddress(String address) {
        int propertyId = -1;
        try (Connection connection = DBConnection.dbConnection();
             PreparedStatement prepare = connection.prepareStatement(
                     DBPropertyConstants.SELECT_PROPERTY_ID)) {
            prepare.setString(1, address);
            try (ResultSet resultSet = prepare.executeQuery()) {
                if (resultSet.next()) {
                    propertyId = resultSet.getInt("id");
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,
                    "An error occurred while fetching property id by address");
        }
        return propertyId;
    }

    public void changeStatus(int propertyId) {
        try (Connection connection = DBConnection.dbConnection();
             PreparedStatement prepare = connection.prepareStatement(DBPropertyConstants.UPDATE_PROPERTY_STATUS)) {
            prepare.setInt(1, propertyId);
            prepare.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,
                    "An error occurred while changing property status!");
        }
    }

    public ObservableList<String> getAvailableProperties(LocalDate startDate, LocalDate endDate) {
        ObservableList<String> availablePropertiesList = FXCollections.observableArrayList();
        if (startDate == null || endDate == null) {
            return availablePropertiesList;
        }
        String sql = DBPropertyConstants.SELECT_AVAILABLE_PROPERTIES;

        try (Connection connect = DBConnection.dbConnection();
             PreparedStatement prepare = connect.prepareStatement(sql)) {

            prepare.setDate(1, Date.valueOf(endDate));
            prepare.setDate(2, Date.valueOf(startDate));
            ResultSet resultSet = prepare.executeQuery();

            while (resultSet.next()) {
                availablePropertiesList.add(resultSet.getString("address"));
            }

        } catch (SQLException e) {
            Logger.getLogger(PropertyRepository.class.getName()).log(Level.SEVERE,
                    "An error occurred while retrieving available properties");
        }


        return availablePropertiesList;
    }
}
