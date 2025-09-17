package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// meget simpelt DB-connection class
public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/kailua_rental?serverTimezone=UTC";
    private static final String USER = "zak";
    private static final String PASS = "1234";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
