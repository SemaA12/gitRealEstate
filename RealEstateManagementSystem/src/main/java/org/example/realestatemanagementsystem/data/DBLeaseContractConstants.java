package org.example.realestatemanagementsystem.data;

public interface DBLeaseContractConstants {
    String SELECT_LEASE_CONTRACTS = "SELECT * FROM lease_contracts WHERE id = ?";
    String INSERT_LEASE_CONTRACT = "INSERT INTO lease_contracts (tenant_id, property_id, start_date, end_date, rent_amount, payment_status, contract) VALUES(?,?,?,?,?,?,?)";
    String SELECT_CONTRACT = "SELECT contract FROM lease_contracts WHERE id = ?";
    String SELECT_ALL_LEASE_CONTRACTS = "SELECT * FROM lease_contracts";
    String SELECT_LEASE_CONTRACT_WITH_PROPERTIES = """
            SELECT lc.id, lc.tenant_id, lc.property_id, lc.rent_amount, lc.payment_status, lc.contract, p.address
            FROM lease_contracts lc
            JOIN properties p ON lc.property_id = p.id
            """;
    String UPDATE_LEASE_CONTRACT = """
            UPDATE lease_contracts SET tenant_id = ?, property_id = ?, start_date = ?, end_date = ?, rent_amount = ?, payment_status = ?, contract = ? WHERE id = ?
            """;
}
