package org.JanClasses.Rest.Menu;

import org.example.Main;

public class PrintMenu {
    public static void menuPrinter(String using, String filename) {
        System.out.println("\n");
        System.out.println("Enter choice: ");
        System.out.println("1. Add a task.");
        System.out.println("2. Check a task.");
        System.out.println("3. Check all tasks.");
        System.out.println("4. Check undone tasks.");
        System.out.println("5. Check done tasks");
        System.out.println("6. Delete a task.");
        System.out.println("7. Mark task done.");
        if (!using.equals("Txt")) {
            System.out.println("8. Update the '" + filename + "' file.");
            if (using.equals("MySQL")) {
                System.out.println("9. Upload the tasks from '" + filename + "' into MySql database.");
            }
        }
        System.out.println("0. Exit");
        System.out.print("Choice: ");
    }
}
