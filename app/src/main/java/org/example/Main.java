package org.example;

import org.JanClasses.Rest.Menu.PrintMenu;
import org.JanClasses.Rest.Sqlli.Interface.Interface;
import org.JanClasses.Rest.Sqlli.Versions.MySqlVersion;
import org.JanClasses.Rest.WhichDatabaseUsing.DatabaseResult;
import org.JanClasses.Rest.WhichDatabaseUsing.WhichDatabase;
import org.JanClasses.Rest.Sqlli.importFromFile.FromTxtToArray;
import org.JanClasses.Rest.Sqlli.importFromFile.FromTxtToMySql;
import org.JanClasses.Cases.UpdateTxt;
import org.JanClasses.Rest.TasksInfo.*;
import org.JanClasses.Cases.*;
import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileName = "TasksList.txt";

        DatabaseResult dbResult = WhichDatabase.Database(fileName);
        Interface.TaskRepository repo = dbResult.repo;
        String using = dbResult.using;
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            ArrayList<TaskDetails> taskList = (ArrayList<TaskDetails>) repo.getAllTasks();
            PrintMenu.menuPrinter(using, fileName);
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    AddTask.taskAdder(taskList);
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
                    DeleteFile.removeLine(taskList);
                    break;
                case 7:
                    TaskUpdater.updateTaskInFile(taskList);
                    break;
                case 8:
                    UpdateTxt.TxtFileUpdate(fileName, taskList);
                    break;
                case 9:
                    taskList = FromTxtToArray.getAllTasksFromFile(fileName);
                    break;

            }
            repo.clearAll();
            repo.addTasks(taskList);
        } while (choice != 0);
    }
}