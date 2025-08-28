package org.JanClasses.Rest.TasksInfo;

public class TaskDetails {
    public String id;
    public String title;
    public String description;
    public int done;

    public TaskDetails(String id, String title, String description, int done) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.done = done;
    }

    public String toString() {
        return "Id: "  + id + " | Title: "  + title +" | Description: "  + description + " | Done: " + done;
    }
    public String toPlainString() {
        return id + ", " + title + ", " + description + ", " + done;
    }
}
