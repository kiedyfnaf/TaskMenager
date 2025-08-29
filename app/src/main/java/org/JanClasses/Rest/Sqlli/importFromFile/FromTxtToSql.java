package org.JanClasses.Rest.Sqlli.importFromFile;

import java.io.*;
import java.sql.*;
import org.JanClasses.Rest.Sqlli.Versions.SqlVersion;

public class FromTxtToSql {
    public static Connection connect(String DB_URL) throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    public static void importFromFile(String filename) {
        String db_url = SqlVersion.DB_URL;

        try (Connection conn = connect(db_url);
             BufferedReader br = new BufferedReader(new FileReader(filename))) {

            String line;
            String insert = "INSERT INTO tasks(id, title, description, done) VALUES(?, ?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(insert)) {

                boolean hasData = false;
                while ((line = br.readLine()) != null) {
                    hasData = true;
                    String[] parts = line.split(",", -1); // keep empty fields
                    if (parts.length >= 4) {
                        pstmt.setString(1, parts[0].trim()); // id
                        pstmt.setString(2, parts[1].trim()); // title
                        pstmt.setString(3, parts[2].trim()); // description
                        pstmt.setInt(4, Integer.parseInt(parts[3].trim())); // status
                        pstmt.executeUpdate();
                    }
                }

                if (!hasData) {
                    System.out.println("Your TXT file is empty.");
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading TXT file: " + filename);
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

