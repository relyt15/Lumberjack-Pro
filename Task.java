package com.example.javafxtest;

public class Task {

    // Task attributes
    private String taskName;
    private String taskDescription;
    private String taskStatus;
    private String taskDueDate;
    private boolean taskCompleted;

    // Constructor to initialize the Task object
    public Task(String name, String description, String dueDate) {
        this.taskName = name;
        this.taskDescription = description;
        this.taskDueDate = dueDate;
        this.taskStatus = "Pending"; // Default status
        this.taskCompleted = false;  // Default not completed
    }

    // Setting up methods to set all data
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public void setTaskDueDate(String taskDueDate) {
        this.taskDueDate = taskDueDate;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public void setTaskCompleted() {
        this.taskCompleted = taskCompleted;
        this.taskStatus = taskCompleted ? "Completed" : "Pending";
    }

    // Setting up methods to get all data
    public String getTaskName() {
        return taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public String getTaskDueDate() {
        return taskDueDate;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public boolean isTaskCompleted() {
        return taskCompleted;
    }
} // end of Task class
