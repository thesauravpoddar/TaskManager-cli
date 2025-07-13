package com.project.taskmanagercli;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Tasks {

    private Integer id;
    private String description;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private final DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

    public Tasks(Status status, Integer id, String description, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.status = Status.TODO;
        this.id = id;
        this.description = description;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Tasks(String description) {
        this.description = description;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void updateDescription(String description) {
        this.description = description;
        this.updatedAt = LocalDateTime.now();
    }

    public void marksInProgress() {
        this.status = Status.MARK_IN_PROGRESS;
        this.updatedAt = LocalDateTime.now();

    }
    public void marksDone() {
        this.status = Status.DONE;
        this.updatedAt = LocalDateTime.now();
    }



    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Tasks{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", formatter=" + formatter +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Tasks tasks = (Tasks) o;
        return Objects.equals(id, tasks.id) && Objects.equals(description, tasks.description) && status == tasks.status && Objects.equals(createdAt, tasks.createdAt) && Objects.equals(updatedAt, tasks.updatedAt) && Objects.equals(formatter, tasks.formatter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, status, createdAt, updatedAt, formatter);
    }

    // now escaping the JSON data into JSON string and later we will unescape it
    public String toJson() {
        return "{\"id\":\"" + id + "\" , \"description\":\"" + description.strip() + "\", \"status\":\"" + status.toString() + "\", \"createdAt\":\"" + createdAt.format(formatter) + "\", \"updatedAt\":\"" + updatedAt.format(formatter) + "\"}";
    }

    // now UnEscaping the JSON string using fromJSON method, we can use jq tool but external tools are not allowed
    public static void fromJson(String json) {
        // First, we will replace all the curly brackets by double quotes ""
        json = json.replace("{" , "").replace("}" , "");
        // now we will use delimiter to split the JSON in words and store in String Array and Regex we will use is ","
        String[] json1 = json.split(",");

        // so in JSON sting array each attribute like id, description and all are saved in respective order, so
        // by using index over reference variable json1, we can access those attributes to work with
        // one by one we will access all the attributes
        String id = json1[0].split(":")[1].strip().replace("\"" , "");
        String description = json1[1].split(":")[1].strip().replace("\"" , "");
        String StrStatus = json1[2].split(":")[1].strip().replace("\"" , "");
        String StrCreatedAt = json1[3].split(":")[1].strip().replace("\"" , "");
        String StrUpdatedAt = json1[4].split(":")[1].strip().replace("\"" , "");

        // status is the reference variable of type Status not string, so we will convert its type from String to Status
        Status status = Status.valueOf(StrStatus.toUpperCase());

        // so now we will update the description
        Tasks task = new Tasks(description);
        task.id = Integer.parseInt(id);
        task.status = status;
        task.createdAt = LocalDateTime.parse(StrCreatedAt );
        task.updatedAt = LocalDateTime.parse(StrUpdatedAt);



    }


}
