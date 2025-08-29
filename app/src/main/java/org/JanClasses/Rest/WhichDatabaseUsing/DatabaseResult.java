package org.JanClasses.Rest.WhichDatabaseUsing;

import org.JanClasses.Rest.Sqlli.Interface.Interface;

public class DatabaseResult {
    public final Interface.TaskRepository repo;
    public final String using;

    public DatabaseResult(Interface.TaskRepository repo, String using) {
        this.repo = repo;
        this.using = using;
    }
}