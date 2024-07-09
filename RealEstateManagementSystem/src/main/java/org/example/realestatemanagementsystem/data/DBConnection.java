package org.example.realestatemanagementsystem.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {

    public static Connection dbConnection() {
        Connection connection;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/real_estates", "root", "Sizene86!");
            return connection;
        } catch (Exception e) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE,
                    "Failed to connect to database!");
        }
        return null;
    }
}
