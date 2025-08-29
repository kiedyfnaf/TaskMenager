package org.JanClasses.Cases;

import org.JanClasses.Rest.TasksInfo.TaskDetails;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskUpdater {
    public static void updateTaskInFile(ArrayList<TaskDetails> taskList) {
        try {
            Scanner scanner7 = new Scanner(System.in);
            System.out.print("\n");
            System.out.print("Enter task id: ");
            String taskId4 = scanner7.next();
            for (TaskDetails task : taskList) {
                if (task.id.equals(taskId4)) {
                    task.done = 1;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}