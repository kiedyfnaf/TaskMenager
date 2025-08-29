package org.JanClasses.Rest.Sqlli.importFromFile;

import org.JanClasses.Rest.TasksInfo.TaskDetails;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FromTxtToArray {
    public static ArrayList<TaskDetails> getAllTasksFromFile(String filename) {
        ArrayList<TaskDetails> taskList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length == 4) {
                    String id = parts[0].trim();
                    String name = parts[1].trim();
                    String description = parts[2].trim();
                    int isDone = Integer.parseInt(parts[3].trim());
                    taskList.add(new TaskDetails(id, name, description, isDone));
                }
            }
        } catch (IOException e) {

        }
        return taskList;
    }
}

