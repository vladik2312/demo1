package com.example.demo;

import java.sql.*;
import java.util.Random;

public class MySQLConnection {
    static final String DB_URL = "jdbc:mysql://sql8.freesqldatabase.com:3306/sql8694985";
    static final String USER = "sql8694985";
    static final String PASS = "ALKbPJJDud";

    public void createRecord(String data) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String randomData = generateRandomData();
            String sql = "INSERT INTO my_table (value) VALUES (?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, randomData);
            stmt.executeUpdate();
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }


    public String readRecordById(String id, String column) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String record = null;

        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "SELECT " + column + " FROM your_table WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                record = rs.getString(column);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return record;
    }


    public void updateRecord(String id, String newData) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "UPDATE your_table SET column_name = ? WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, newData);
            stmt.setString(2, id);
            stmt.executeUpdate();
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }


    public void deleteRecord(String id) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "DELETE FROM your_table WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
    private String generateRandomData() {
        Random random = new Random();
        // Генеруємо рандомну інформацію, наприклад, рядок з випадковими символами
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            stringBuilder.append(characters.charAt(random.nextInt(characters.length())));
        }
        return stringBuilder.toString();
    }
}
