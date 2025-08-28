package org.JanClasses.Cases;

import org.JanClasses.Rest.TasksInfo.TaskDetails;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;

public class DeleteFile {
    public static void removeLine(String fileName, ArrayList<TaskDetails> taskList) throws IOException {
        Scanner scanner6 = new Scanner(System.in);
        System.out.print("\n");
        System.out.print("Enter task id: ");
        String indexId = scanner6.next();
        taskList.removeIf(p -> p.id.equals(indexId));

        try (Writer fileWriter = new FileWriter(fileName, false)) {
            for (TaskDetails p : taskList) {
                fileWriter.write(p.toPlainString() + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}