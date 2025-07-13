package com.project.taskmanagercli;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

// here we will write code to read, write and save tasks in JSON file

public class SavingTasks {
    private static final Path FILE_PATH = Path.of("tasks.json");
    private final List<Tasks> tasks;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_DATE_TIME;

    public SavingTasks() {
        this.tasks = loadTasks();
        }

    private static List<Tasks> loadTasks() {
        List<Tasks> stored_tasks = new ArrayList<>();
        if(!Files.exists(FILE_PATH)) {
            return new ArrayList<>();
        }
        try {
            String jsonContent = Files.readString(FILE_PATH);
            String[] list_of_tasks = jsonContent.replace("[" , "").replace("]" , "").split(",");

                    for(int i = 0; i < list_of_tasks.length; i++) {
                        if(!list_of_tasks[i].endsWith("}")) {
                            list_of_tasks[i] = list_of_tasks[i] + "}";
                            stored_tasks.add(Tasks.fromJson(list_of_tasks[i]));
                        } else {
                            stored_tasks.add(Tasks.fromJson(list_of_tasks[i]));
                        }
                    }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stored_tasks;
    }
            // now we are going to add tasks
    public void AddTask(String description) throws IOException {

        Tasks new_task = new Tasks(description);
        tasks.add(new_task);

        saveTasks();
        System.out.println("Task added successfully, ID: " + new_task.getId());

    }

    // implementing all other methods like update task , delete task , marksInProgress , mark done and all
    public void UpdateTask(String id , String new_description) {
        Tasks tasks1 = findTask(id).orElseThrow(() -> new IllegalArgumentException("Task with this is id" + id + "not found"));
        tasks1.updateDescription(new_description);
    }

    public void DeleteTask(String id) {
        Tasks tasks2 = findTask(id).orElseThrow(() -> new IllegalArgumentException("Task with this is id" + id + "not found"));
        tasks.remove(tasks2);
    }

    public void markTaskInProgress(String id) {
        Tasks tasks3 = findTask(id).orElseThrow(() -> new IllegalArgumentException("Task with this is id" + id + "not found"));
        tasks3.marksInProgress();
    }
    public void markTaskAsDone(String id) {
        Tasks tasks4 = findTask(id).orElseThrow(() -> new IllegalArgumentException("Task with this is id" + id + "not found"));
        tasks4.markAsDone();
    }

    public Optional<Tasks> findTask(String id) {
       return tasks.stream()
                .filter(task -> task.getId().
                        equals(Integer.parseInt(id))).findFirst();
    }

        // now listing all the tasks
        public void ListTasks(String type) {
          for(Tasks task : tasks) {
              String status = task.getStatus().toString().strip();
              if(type.equals("All") || status.equals(type)) {
                  System.out.println(task.toString());
              }
          }
        }


    public void saveTasks() throws IOException {

        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(FILE_PATH)) {
            bufferedWriter.write("[\n");
            for(int i = 0; i < tasks.size(); i++) {
                bufferedWriter.write(tasks.get(i).toJson());
                if(i < tasks.size() - 1) {
                    bufferedWriter.write(",\n");
                }
            }
            bufferedWriter.write("]");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
