package org.JanClasses.Rest.Sqlli.Interface;

import org.JanClasses.Rest.TasksInfo.TaskDetails;
import java.util.ArrayList;
import java.util.List;

public class Interface {
    public interface TaskRepository {
        void addTasks(ArrayList<TaskDetails> tasks);
        void clearAll();
        List<TaskDetails> getAllTasks();
        boolean isDatabaseEmpty(String filename);
    }
}