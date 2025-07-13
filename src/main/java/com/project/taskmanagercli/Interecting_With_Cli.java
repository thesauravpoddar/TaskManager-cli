package com.project.taskmanagercli;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Interecting_With_Cli {

    public static void Ineterection_with_cli() throws IOException {
        Scanner scanner = new Scanner(System.in);
        SavingTasks savingTasks = new SavingTasks();

        System.out.println("*******Welcome to Cli interface where you can manage your tasks******");
            System.out.println("\nEnter Your command: ");
            System.out.print(">");
            String input = scanner.nextLine().trim();
            String[] parts = input.split(" ");
            String command = parts[0].toLowerCase();

            switch(command) {
                case "add" :
                    if(parts.length < 2) {
                        System.out.println("Please give the description of the task you want to add");
                        return;
                    } else {
                        savingTasks.AddTask(parts[1]);
                    }
                    break;
                case "list" :
                   if(parts.length < 2) {
                       savingTasks.ListTasks("All");
                   }else {
                       Status Current_Status;
                       try{
                           Current_Status = Status.valueOf(parts[1].toUpperCase().replace("-" , "_"));
                       } catch (IllegalArgumentException e) {
                           System.out.println("Please enter a valid status");
                           return;
                       }
                       savingTasks.ListTasks(Current_Status.toString());
                   }
                    break;
                case "remove" :
                    System.out.println("enter the id of the task you want to remove");
                    savingTasks.DeleteTask(scanner.nextLine());
                    System.out.println("Task removed");
                    break;
                case "update" :
                    System.out.println("enter the id of the task you want to update");
                    String id = scanner.nextLine().trim();
                    System.out.println("Enter the new description of the task you want to update");
                    String description = scanner.nextLine().trim();
                    savingTasks.UpdateTask(id , description);
                    System.out.println("You have successfully updated the task");
                    break;
                case "mark-in-progress" :
                    System.out.println("enter the id of the task you want to mark as progress");
                    savingTasks.markTaskInProgress(scanner.nextLine());
                    System.out.println("You have successfully marked the task as progress");
                    break;
                case "mark-as-done" :
                    System.out.println("enter the id of the task you want to mark as done");
                    savingTasks.markTaskAsDone(scanner.nextLine());
                    System.out.println("You have successfully marked the task as done");
                    break;
                case "exit" :
                    System.out.println("exiting application");
                    return;
                default:
                    System.out.println("Invalid command");
            }
            savingTasks.saveTasks();
    }

}
