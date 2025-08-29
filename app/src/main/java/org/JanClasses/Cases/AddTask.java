package org.JanClasses.Cases;

import org.JanClasses.Rest.TasksInfo.TaskDetails;
import java.util.ArrayList;
import java.util.Scanner;

public class AddTask {
    public static void taskAdder(ArrayList<TaskDetails> taskList) {
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
        taskList.add(addNewTask);
    }
}
