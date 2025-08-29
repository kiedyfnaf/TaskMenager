package org.JanClasses.Rest.Sqlli.importFromFile;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;


import org.JanClasses.Rest.Sqlli.Interface.Interface;
import org.JanClasses.Rest.Sqlli.Versions.MySqlVersion;
import org.JanClasses.Rest.TasksInfo.TaskDetails;


public class FromTxtToMySql {

    public static void importFromFile(String filename, Interface.TaskRepository repo) {
        try (Connection conn = MySqlVersion.connect();
             BufferedReader br = new BufferedReader(new FileReader(filename))) {
            repo.clearAll();
            ArrayList<TaskDetails> tasklist = FromTxtToArray.getAllTasksFromFile(filename);
            repo.addTasks(tasklist);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}