package org.JanClasses.Cases;

import org.JanClasses.Rest.TasksInfo.TaskDetails;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class UpdateTxt {
    public static void TxtFileUpdate(String filename, ArrayList<TaskDetails> tasks){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, false))) {
            for (TaskDetails task : tasks) {
                writer.write(task.toPlainString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
