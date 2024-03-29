package com.insider.database;

import java.sql.*;

import static com.insider.core.PropertiesFile.*;

public class MySqlConnection {

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void insertMySql(String testName, String testInstanceName, String testStatus, String testDuration, String stackTrace) {

        Connection conn =  getConnection();
        PreparedStatement pstmt = null;

        try {
            // SQL sorgusu hazirlanir
            String sql = "INSERT INTO testdb.AutomationReports (TestName, TestInstanceName,TestStatus, TestDuration, StackTrace) VALUES (?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);

            // Parametreler set edilir
            pstmt.setString(1, testName);
            pstmt.setString(2, testInstanceName);
            pstmt.setString(3, testStatus);
            pstmt.setString(4, testDuration);
            pstmt.setString(5, stackTrace);

            // Sorguyu çalıştır
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Test sonucu veri tabanina eklendi...");
            } else {
                System.out.println("Test sonucu veri tabanina eklenemedi...");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Bağlantıyı ve PreparedStatement'i kapat
            try {
                if (pstmt != null)
                    pstmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

