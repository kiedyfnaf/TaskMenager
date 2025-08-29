package org.JanClasses.Rest.Sqlli.Versions;

import java.sql.*;
import java.util.ArrayList;
import org.JanClasses.Rest.Sqlli.Interface.Interface;
import org.JanClasses.Rest.TasksInfo.TaskDetails;

public class MySqlVersion implements Interface.TaskRepository {
    private static final String url = "jdbc:mysql://localhost:3306/taskingdb"; // 👈 DB
    private static final String user = "MB"; // 👈 your MySQL user
    private static final String password = "Jandrzej1!"; // 👈 your MySQL password

    public MySqlVersion() {
        createTableIfNotExists();
    }

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    private void createTableIfNotExists() {
        String sql = """
            CREATE TABLE IF NOT EXISTS tasking (
                id VARCHAR(50) ,
                title VARCHAR(250) ,
                description TEXT,
                done INT
            )
        """;
        try (Connection conn = connect(); Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addTasks(ArrayList<TaskDetails> tasks) {
        String sql = "INSERT INTO tasking (id, title, description, done) VALUES (?, ?, ?, ?)";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for (TaskDetails task : tasks) {
                pstmt.setString(1, task.id);
                pstmt.setString(2, task.title);
                pstmt.setString(3, task.description);
                pstmt.setInt(4, task.done);
                pstmt.addBatch(); // 👈 collect tasks
            }
            pstmt.executeBatch(); // 👈 insert all at once
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<TaskDetails> getAllTasks() {
        ArrayList<TaskDetails> tasks = new ArrayList<>();
        String sql = "SELECT id, title, description, done FROM tasking";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                tasks.add(new TaskDetails(
                        rs.getString("id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getInt("done")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    @Override
    public void clearAll() {
        String sql = "DELETE FROM tasking";
        try (Connection conn = connect(); Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isDatabaseEmpty(String filename) {
        String sql = "SELECT COUNT(*) FROM tasking";
        try (Connection conn = connect(); Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) { // Move to the first row
                return rs.getInt(1) == 0; // True if no rows
            }
            return true; // Default to empty if query fails to return rows
        } catch (SQLException e) {
            System.out.println("Error checking database: " + e.getMessage());
            return true; // Safe default on error (assume empty to avoid crash)
        }
    }
}
