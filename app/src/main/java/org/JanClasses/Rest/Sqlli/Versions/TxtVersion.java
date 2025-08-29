package org.JanClasses.Rest.Sqlli.Versions;

import java.io.*;
import java.util.ArrayList;
import org.JanClasses.Rest.Sqlli.Interface.Interface;
import org.JanClasses.Rest.TasksInfo.TaskDetails;

public class TxtVersion implements Interface.TaskRepository {
    private final String filename;

    public TxtVersion(String filename) {
        this.filename = filename;
    }

    @Override
    public ArrayList<TaskDetails> getAllTasks() {
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

    @Override
    public void clearAll() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter (filename, false))) {
            writer.write("");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addTasks(ArrayList<TaskDetails> tasks) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, false))) {
            for (TaskDetails task : tasks) {
                writer.write(task.toPlainString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isDatabaseEmpty(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            return reader.readLine() == null;
        } catch (IOException e) {
            return true;
        }

    }
}