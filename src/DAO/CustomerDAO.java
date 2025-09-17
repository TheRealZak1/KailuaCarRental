package DAO;

import model.Customer;
import model.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// DAO = Data Access Object
// Her laver jeg metoder til at snakke med Customer-tabellen i DB
public class CustomerDAO {

    // metode til at indsætte en kunde i databasen
    public void addCustomer(Customer customer) {
        String sql = "INSERT INTO Customer (name, address, zip, city, mobilePhone," +
                " phone, email, driverLicenseNumber, driverSince) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getAddress());
            stmt.setString(3, customer.getZip());
            stmt.setString(4, customer.getCity());
            stmt.setString(5, customer.getMobilePhone());
            stmt.setString(6, customer.getPhone());
            stmt.setString(7, customer.getEmail());
            stmt.setString(8, customer.getDriverLicenseNumber());
            stmt.setString(9, customer.getDriverSince());

            stmt.executeUpdate();
            System.out.println(" Kunde blev indsat i databasen");

        } catch (SQLException e) {
            System.out.println(" Fejl ved indsættelse af kunde: " + e.getMessage());
        }
    }

    // metode til at hente alle kunder
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM Customer";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Customer c = new Customer();
                c.setCustomerId(rs.getInt("customerId"));
                c.setName(rs.getString("name"));
                c.setAddress(rs.getString("address"));
                c.setZip(rs.getString("zip"));
                c.setCity(rs.getString("city"));
                c.setMobilePhone(rs.getString("mobilePhone"));
                c.setPhone(rs.getString("phone"));
                c.setEmail(rs.getString("email"));
                c.setDriverLicenseNumber(rs.getString("driverLicenseNumber"));
                c.setDriverSince(rs.getString("driverSince"));

                customers.add(c);
            }

        } catch (SQLException e) {
            System.out.println(" Fejl ved hentning af kunder: " + e.getMessage());
        }

        return customers;
    }
}
