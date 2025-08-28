package org.example;

import org.JanClasses.Rest.Menu.PrintMenu;
import org.JanClasses.Rest.TasksInfo.*;
import org.JanClasses.Rest.Writer.WriteFile;
import org.JanClasses.Cases.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileName = "TasksList.txt";
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            ArrayList<TaskDetails> taskList = TasksDuringRuntime.runtimeTasksArray(fileName);
            PrintMenu.menuPrinter();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    AddTask.taskAdder(fileName);
                    break;
                case 2:
                    CheckTask.taskChecker(taskList);
                    break;
                case 3:
                    CheckTask.taskCheckerAll(taskList);
                    break;
                case 4:
                    CheckTask.taskCheckerNotDone(taskList);
                    break;
                case 5:
                    CheckTask.taskCheckerDone(taskList);
                    break;
                case 6:
                    DeleteFile.removeLine(fileName, taskList);
                    break;
                case 7:
                    TaskUpdater.updateTaskInFile(fileName, taskList);
                    break;
            }
        } while (choice != 0);
    }
}