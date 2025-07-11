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
}
