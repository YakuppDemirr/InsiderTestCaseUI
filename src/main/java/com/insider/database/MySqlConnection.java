package com.insider.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
    public static void insertMySql(String testName, String testInstanceName, String testStatus, String testDuration) {

        Connection conn =  getConnection();
        PreparedStatement pstmt = null;

        try {
            // SQL sorgusu hazirlanir
            String sql = "INSERT INTO testdb.AutomationReports (TestName, TestInstanceName,TestStatus, TestDuration) VALUES (?,?,?,?)";
            pstmt = conn.prepareStatement(sql);

            // Parametreler set edilir
            pstmt.setString(1, testName);
            pstmt.setString(2, testInstanceName);
            pstmt.setString(3, testStatus);
            pstmt.setString(4, testDuration);

            // Sorguyu çalıştır
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Veri eklendi.");
            } else {
                System.out.println("Veri eklenemedi.");
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

