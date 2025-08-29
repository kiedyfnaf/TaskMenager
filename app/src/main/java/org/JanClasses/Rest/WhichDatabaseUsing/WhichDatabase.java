package org.JanClasses.Rest.WhichDatabaseUsing;

import org.JanClasses.Rest.Sqlli.Interface.Interface;
import org.JanClasses.Rest.Sqlli.Versions.MySqlVersion;
import org.JanClasses.Rest.Sqlli.Versions.SqlVersion;
import org.JanClasses.Rest.Sqlli.Versions.TxtVersion;
import org.JanClasses.Rest.Sqlli.importFromFile.FromTxtToMySql;
import org.JanClasses.Rest.Sqlli.importFromFile.FromTxtToSql;

public class WhichDatabase {
    public static DatabaseResult Database(String fileName) {
        Interface.TaskRepository repo;
        String using;


        try {
            // Try MySQL first
            repo = new MySqlVersion();
            System.out.println("Using MySQL database.");
            if (repo.isDatabaseEmpty(fileName)) {
                System.out.println("MySQL database is empty, importing tasks from file...");
                FromTxtToMySql.importFromFile(fileName, repo);
            }
            using = "MySQL";

        } catch (Exception mysqlEx) {
            try {
                // Fallback to SQLite
                repo = new SqlVersion();
                System.out.println("Using SQLite database.");
                if (repo.isDatabaseEmpty(fileName)) {
                    System.out.println("SQLite database is empty, importing tasks from file...");
                    FromTxtToSql.importFromFile(fileName);
                }
                using = "SQLite";

            } catch (Exception sqliteEx) {
                // Fallback to TXT
                repo = new TxtVersion(fileName);
                System.out.println("Using Txt version.");
                if (repo.isDatabaseEmpty(fileName)) {
                    System.out.println("Couldn't connect to MySQL/SQLite and your Txt file is empty.");
                    System.out.println("Please fix DB connection or add at least one task in Txt file.");
                }
                using = "Txt";
            }
        }

        return new DatabaseResult(repo, using);
    }
}
