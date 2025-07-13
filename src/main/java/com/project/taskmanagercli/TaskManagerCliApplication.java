package com.project.taskmanagercli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class TaskManagerCliApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication app = new SpringApplication(TaskManagerCliApplication.class);
        app.setWebApplicationType(WebApplicationType.NONE);
        app.run(args);
        Interecting_With_Cli.Ineterection_with_cli();
    }

}
