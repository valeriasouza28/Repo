package com.alura.literatura.literatura;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:h2:./booksDB";

    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to H2 has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static void createNewTable() {
        String sql = "CREATE TABLE IF NOT EXISTS books (\n"
                + " id INTEGER PRIMARY KEY AUTO_INCREMENT,\n"
                + " title VARCHAR(255) NOT NULL,\n"
                + " author VARCHAR(255) NOT NULL\n"
                + ");";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table created.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        connect();
        createNewTable();
    }
}
