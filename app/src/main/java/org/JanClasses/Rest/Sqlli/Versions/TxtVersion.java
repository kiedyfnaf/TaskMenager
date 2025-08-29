package org.JanClasses.Rest.Sql.Versions;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TxtVersion implements org.JanClasses.Rest.Sql.Interface.Interface.TaskRepository {
    private final String filename;

    public TxtVersion(String filename) {
        this.filename = filename;
    }

    @Override
    public void addTask(String id, String title, String description, int status) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))) {
            bw.write(id + "," + title + "," + description + "," + status);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> listTasks() {
        List<String> tasks = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",", -1);
                tasks.add(parts[0] + " | " + parts[1] + " | " + (Integer.parseInt(parts[3]) == 1 ? "Done" : "Pending"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tasks;
    }
}