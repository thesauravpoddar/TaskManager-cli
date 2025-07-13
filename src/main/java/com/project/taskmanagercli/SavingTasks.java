package com.project.taskmanagercli;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class SavingTasks {
    private static final String FILE_NAME = "tasks.json";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_DATE_TIME;

    // now we will create a list of tasks
    public static void saveTasks(List<Tasks> tasks) throws IOException {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.write("[\n");
            for(int i = 0; i < tasks.size(); i++) {
                Tasks task = tasks.get(i);
                writer.write("   {\n");
                writer.write("      \"id\": " + task.getId() + ",\n");
                writer.write("      \"description\": " + task.getDescription() + ",\n");
                writer.write("      \"status\": " + task.getStatus() + ",\n");
                writer.write("      \"createdAt\": + task.getCreatedAt() + \n");
                writer.write("      \"updatedAt\": + task.getUpdatedAt() + \n");
                writer.write("}"  + (i < tasks.size() - 1 ? "," : "") + "\n");
            }
            writer.write("]");
            System.out.println("your task is successfully saved to " + FILE_NAME);
        }
        catch (IOException e) {
            System.err.println("your task failed to save " + e.getMessage());
        }

    }

}
