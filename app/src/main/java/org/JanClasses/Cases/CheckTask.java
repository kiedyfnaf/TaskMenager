package org.JanClasses.Cases;

import org.JanClasses.Rest.TasksInfo.TaskDetails;

import java.util.ArrayList;
import java.util.Scanner;

public class CheckTask {
    public static void taskChecker(ArrayList<TaskDetails> taskList) {
        Scanner scanner2 = new Scanner(System.in);
        System.out.print("\n");
        System.out.print("Enter task id: ");
        String taskId3 = scanner2.next();
        System.out.print("\n");
        for (TaskDetails task : taskList) {
            if (taskId3.equals(task.id)) {
                System.out.println(task);
            }
        }
    }
    public static void taskCheckerAll(ArrayList<TaskDetails> taskList) {
        System.out.print("\n");
        for (TaskDetails p : taskList) {
            System.out.println(p);
        }
    }

    public static void taskCheckerDone(ArrayList<TaskDetails> taskList) {
        System.out.print("\n");
        for (TaskDetails p : taskList) {
            if (p.done == 1) {
                System.out.println(p);
            }
        }
    }

    public static void taskCheckerNotDone(ArrayList<TaskDetails> taskList) {
        System.out.print("\n");
        for (TaskDetails p : taskList) {
            if (p.done == 0) {
                System.out.println(p);
            }
        }
    }
}
