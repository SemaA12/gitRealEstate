package org.example.realestatemanagementsystem.repositories;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.realestatemanagementsystem.data.DBConnection;
import org.example.realestatemanagementsystem.data.DBLeaseContractConstants;
import org.example.realestatemanagementsystem.data.DBTenantConstants;
import org.example.realestatemanagementsystem.data.LeaseContractsData;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LeaseContractRepository {
    public ObservableList<LeaseContractsData> getLeaseContracts() {

        ObservableList<LeaseContractsData> contractsList = FXCollections.observableArrayList();
        try (Connection connection = DBConnection.dbConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     DBLeaseContractConstants.SELECT_LEASE_CONTRACT_WITH_PROPERTIES)) {

            while (resultSet.next()) {
                LeaseContractsData contract = new LeaseContractsData();
                contract.setId(resultSet.getInt("id"));
                contract.setTenantId(resultSet.getInt("tenant_id"));
                contract.setPropertyId(resultSet.getInt("property_id"));
                contract.setRentAmount(resultSet.getDouble("rent_amount"));
                contract.setPaymentStatus(resultSet.getString("payment_status"));
                contract.setContract(resultSet.getString("contract"));
                contract.setPropertyAddress(resultSet.getString("address"));

                contractsList.add(contract);
            }
        } catch (SQLException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,
                    "An error occurred while retrieving lease contracts from database!");
        }
        return contractsList;
    }

    public ObservableList<String> getTenantsWithLeaseContract() {
        ObservableList<String> tenantsList = FXCollections.observableArrayList();

        try (Connection connection = DBConnection.dbConnection();
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery(
                     DBTenantConstants.SELECT_TENANTS_WITH_LEASE_CONTRACTS)) {
            while (result.next()) {
                tenantsList.add(result.getString("email"));
            }
        } catch (SQLException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,
                    "An error occurred while retrieving tenants with lease contracts from database!");
            return FXCollections.observableArrayList();
        }
        return tenantsList;
    }

    public ObservableList<String> getTenantsWithoutLeaseContract() {
        ObservableList<String> tenantsList = FXCollections.observableArrayList();

        try (Connection connection = DBConnection.dbConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     DBTenantConstants.SELECT_TENANTS_WITHOUT_LEASE_CONTRACTS)) {

            while (resultSet.next()) {
                tenantsList.add(resultSet.getString("email"));
            }
        } catch (SQLException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,
                    "An error occurred while retrieving tenants without lease contracts from database", e);
            return FXCollections.observableArrayList();
        }
        return tenantsList;
    }
}
