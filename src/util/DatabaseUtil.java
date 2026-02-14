package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseUtil {

    private static final String URL = "jdbc:mysql://localhost:3306/student_db";
    private static final String USER = "root";
    private static final String PASSWORD = "your_password";

    public static Connection getConnection() {
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database Connected Successfully!");
            return con;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Database connection failed");
        }
    }
}
