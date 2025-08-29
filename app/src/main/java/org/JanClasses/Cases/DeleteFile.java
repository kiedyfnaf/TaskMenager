package org.JanClasses.Cases;

import org.JanClasses.Rest.TasksInfo.TaskDetails;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DeleteFile {
    public static void removeLine(ArrayList<TaskDetails> taskList) throws IOException {
        Scanner scanner6 = new Scanner(System.in);
        System.out.print("\n");
        System.out.print("Enter task id: ");
        String indexId = scanner6.next();
        taskList.removeIf(p -> p.id.equals(indexId));
    }
}