package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class DatabaseHelper {

    static String url = "jdbc:sqlite:resume.db";

    // 🔹 STEP 2 (already)
    public static void createTable() {
        try {
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();

            String sql = "CREATE TABLE IF NOT EXISTS resumes (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "filename TEXT," +
                    "score INTEGER," +
                    "skills TEXT" +
                    ");";

            stmt.execute(sql);
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🔹 STEP 3 (YAHI ADD KARNA HAI 👇)
    public static void insertData(String filename, int score, String skills) {
        try {
            Connection conn = DriverManager.getConnection(url);

            String sql = "INSERT INTO resumes(filename, score, skills) VALUES(?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, filename);
            pstmt.setInt(2, score);
            pstmt.setString(3, skills);

            pstmt.executeUpdate();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}