package org.JanClasses.Rest.Sql.Interface;

import java.util.List;
public class Interface {
    public interface TaskRepository {
        void addTask(String id, String title, String description, int status);

        List<String> listTasks();
    }
}