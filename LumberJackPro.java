package com.example.javafxtest;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LumberJackPro extends Application {
    private VBox taskContainer;

    @Override
    public void start(Stage primaryStage) {
        taskContainer = new VBox(10);  // Container to hold task panes
        Button addTaskButton = new Button("Add New Task");

        addTaskButton.setOnAction(e -> addNewTask());  // Handle button click

        VBox layout = new VBox(10, addTaskButton, taskContainer);  // Overall layout
        Scene scene = new Scene(layout, 300, 400);

        primaryStage.setTitle("Task Manager");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void addNewTask() {
        // Create new Task object (you can later gather this from user input)
        Task newTask = new Task("New Task", "Task description", "2025-02-28");

        // Create TaskPane and add to the layout
        TaskPane taskPane = new TaskPane(newTask);
        taskContainer.getChildren().add(taskPane);
    }

    public static void main(String[] args) {
        launch(args);
    }
}