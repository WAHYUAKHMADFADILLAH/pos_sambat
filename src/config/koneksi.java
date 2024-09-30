package config;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class koneksi {
    private static Connection conn;
    
    public static Connection getConnection() {
        if (conn == null) {
            try {
                String url = "jdbc:mysql://localhost:3306/db_sambat";
                String user = "root";
                String pass = "atmin123";
                
                // The following line is not necessary for MySQL Connector/J 5.0 and later
                // Class.forName("com.mysql.cj.jdbc.Driver");
                
                conn = DriverManager.getConnection(url, user, pass);
                System.out.println("Database connected successfully.");
            } catch (SQLException e) {
                Logger.getLogger(koneksi.class.getName()).log(Level.SEVERE, "SQL Exception: ", e);
                System.out.println("Database connection failed: " + e.getMessage());
            } catch (Exception e) {
                Logger.getLogger(koneksi.class.getName()).log(Level.SEVERE, "Unexpected Exception: ", e);
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
        return conn;
    }
    
    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Database connection closed.");
            } catch (SQLException e) {
                Logger.getLogger(koneksi.class.getName()).log(Level.SEVERE, "Error closing connection: ", e);
            }
        }
    }
}