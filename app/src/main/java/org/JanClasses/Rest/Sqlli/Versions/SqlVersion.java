package org.JanClasses.Rest.Sql.Versions;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.JanClasses.Rest.Sql.Interface.Interface;

public class SqlVersion implements Interface.TaskRepository {
    private static final String DB_URL = "jdbc:sqlite:tasks.db";

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    @Override
    public void addTask(String id, String title, String description, int status) {
        String sql = "INSERT INTO tasks(id, title, description, status) VALUES(?, ?, ?, ?)";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            pstmt.setString(2, title);
            pstmt.setString(3, description);
            pstmt.setInt(4, status);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> listTasks() {
        List<String> tasks = new ArrayList<>();
        String sql = "SELECT id, title, status FROM tasks";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                tasks.add(rs.getString("id") + " | " + rs.getString("title") + " | " +
                        (rs.getInt("status") == 1 ? "Done" : "Pending"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }
}
