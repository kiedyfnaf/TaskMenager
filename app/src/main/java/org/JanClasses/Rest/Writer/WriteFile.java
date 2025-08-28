package org.JanClasses.Rest.Writer;

import java.io.*;

public class WriteFile {
    String fileName;
    boolean append_to_file = false;
    public WriteFile(String fileName, boolean append_to_file) {
        this.fileName = fileName;
        this.append_to_file = append_to_file;
    }

    public void writeToFile(String textLine) throws IOException {
        FileWriter write = new FileWriter(fileName, append_to_file);
        PrintWriter printWriter = new PrintWriter(write);
        printWriter.println(textLine);
        printWriter.close();
    }
}

