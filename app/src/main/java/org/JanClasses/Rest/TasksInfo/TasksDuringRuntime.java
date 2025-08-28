package org.JanClasses.Rest.TasksInfo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TasksDuringRuntime {
    public static ArrayList<TaskDetails> runtimeTasksArray(String fileName) {
        ArrayList<TaskDetails> taskList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");

                if (parts.length == 4) {
                    String id = parts[0].trim();
                    String name = parts[1].trim();
                    String description = parts[2].trim();
                    int isDone = Integer.parseInt(parts[3].trim());

                    TaskDetails task = new TaskDetails(id, name, description, isDone);
                    taskList.add(task);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file");
            e.printStackTrace();
        }
        return taskList; // <-- always return here
    }
}
