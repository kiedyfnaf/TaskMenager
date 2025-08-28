package org.JanClasses.Cases;

import org.JanClasses.Rest.TasksInfo.TaskDetails;
import org.JanClasses.Rest.Writer.WriteFile;

import java.io.IOException;
import java.util.Scanner;

public class AddTask {
    public static void taskAdder(String fileName) {
        System.out.print("\n");
        Scanner scanner1 = new Scanner(System.in);
        System.out.print("Enter task id: ");
        String taskId1 = scanner1.next();
        System.out.print("\n");
        System.out.print("Enter task name: ");
        String taskName = scanner1.next();
        scanner1.nextLine();
        System.out.print("\n");
        System.out.println("Enter task description: ");
        String taskDescription = scanner1.nextLine();
        System.out.print("\n");
        System.out.println("Enter task status (0/1): ");
        int taskStatus = scanner1.nextInt();
        TaskDetails addNewTask = new TaskDetails(taskId1, taskName, taskDescription, taskStatus);
        try {
            WriteFile newTask = new WriteFile(fileName, true);
            newTask.writeToFile(taskId1 + ", " + taskName + ", " + taskDescription + ", " + taskStatus);
        } catch (IOException e) {
            System.out.println("Error writing file");
        }
    }
}
