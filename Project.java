package com.example.javafxtest;

import java.util.Scanner;

public class Project {

    // Project attributes
    private String projectName;
    private String projectDescription;
    private String projectStatus;
    private String projectDueDate;
    private boolean projectCompleted;

    private final Scanner scan = new Scanner(System.in);

    // Constructor to initialize project with default values
    public Project() {
        this.projectName = "";
        this.projectDescription = "";
        this.projectStatus = "Pending"; // Default status
        this.projectDueDate = "";
        this.projectCompleted = false;
    }

    // Constructor with parameters
    public Project(String name, String description, String dueDate) {
        this.projectName = name;
        this.projectDescription = description;
        this.projectStatus = "Pending"; // Default status
        this.projectDueDate = dueDate;
        this.projectCompleted = false;
    }

    // Setters with user input
    public void setProjectName() {
        System.out.print("Enter project name: ");
        this.projectName = scan.nextLine();
    }

    public void setProjectDescription() {
        System.out.print("Enter project description: ");
        this.projectDescription = scan.nextLine();
    }

    public void setProjectDueDate() {
        System.out.print("Enter project due date: ");
        this.projectDueDate = scan.nextLine();
    }

    public void setProjectStatus(String status) {
        this.projectStatus = status;
    }

    public void setProjectCompleted(boolean completed) {
        this.projectCompleted = completed;
        this.projectStatus = completed ? "Completed" : "In Progress";
    }

    // Getters
    public String getProjectName() {
        return projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public String getProjectDueDate() {
        return projectDueDate;
    }

    public String getProjectStatus() {
        return projectStatus;
    }

    public boolean isProjectCompleted() {
        return projectCompleted;
    }

    // Display project details
    public void displayProjectDetails() {
        System.out.println("Project Name: " + projectName);
        System.out.println("Description: " + projectDescription);
        System.out.println("Due Date: " + projectDueDate);
        System.out.println("Status: " + projectStatus);
        System.out.println("Completed: " + (projectCompleted ? "Yes" : "No"));
    }
} // End of Project class
