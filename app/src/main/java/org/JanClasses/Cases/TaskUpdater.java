package org.JanClasses.Cases;

import org.JanClasses.Rest.TasksInfo.TaskDetails;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskUpdater {
    public static void updateTaskInFile(String filePath, ArrayList<TaskDetails> taskList) {
        try {
            Scanner scanner7 = new Scanner(System.in);
            System.out.print("\n");
            System.out.print("Enter task id: ");
            String taskId4 = scanner7.next();
            int lineNumber = 0;
            for (TaskDetails p : taskList) {
                if (taskId4.equals(p.id)) {
                    break;
                }
                lineNumber++;
            }
            List<String> lines = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            reader.close();

            if (lineNumber < lines.size() && lines.get(lineNumber).endsWith("0")) {
                String updatedLine = lines.get(lineNumber).substring(0, lines.get(lineNumber).length() - 1) + "1";
                lines.set(lineNumber, updatedLine);
                BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
                for (String l : lines) {
                    writer.write(l + "\n");
                }
                writer.close();
                System.out.println("\nTask has been updated successfully.");
            } else {
                System.out.println("No such task exists or line doesn't end with '0'.");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
