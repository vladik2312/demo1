package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    // Змініть ці змінні на ваші дані для підключення до MySQL
    static final String DB_URL = "sql8.freesqldatabase.com/sql8694985";
    static final String USER = "sql8694985";
    static final String PASS = "ALKbPJJDud";

    public static void main(String[] args) {
        Connection conn = null;
        try {
            // Крок 1: Реєстрація драйвера JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Крок 2: Встановлення з'єднання
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Крок 3: Робота з базою даних
            // Тут ви можете виконувати SQL запити та інші операції з базою даних

            // Крок 4: Закриття з'єднання
            conn.close();
            System.out.println("Connection closed.");
        } catch (SQLException se) {
            // Обробка помилок JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Обробка інших помилок
            e.printStackTrace();
        } finally {
            // Найкраще закривати з'єднання в блоках finally, щоб гарантувати їх закриття
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
