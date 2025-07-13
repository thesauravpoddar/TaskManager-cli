package com.project.taskmanagercli;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class get_task {
    public static List<Tasks> Get_Task() throws FileNotFoundException { // we want to return the list of tasks to the user
        List<Tasks> tasksList = new ArrayList<Tasks>();
        File file = new File("tasks.json");
        if(!file.exists()) {
            return tasksList;
        }
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
