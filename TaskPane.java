package com.example.javafxtest;

import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class TaskPane extends HBox {
    private Task task;
    private TextField nameField;
    private TextField dueDateField;
    private TextField descriptionField;
    private CheckBox completedCheckBox;
    private Button saveButton;

    public TaskPane(Task task) {
        this.task = task;

        // Text field for Task Name
        nameField = new TextField(task.getTaskName());
        nameField.setPromptText("Task Name");

        // Text field for Task Due Date
        dueDateField = new TextField(task.getTaskDueDate());
        dueDateField.setPromptText("Due Date (YYYY-MM-DD)");

        // Text field for Task Description
        descriptionField = new TextField(task.getTaskDescription());
        descriptionField.setPromptText("Task Description");

        // Checkbox for Completion
        completedCheckBox = new CheckBox("Completed");
        completedCheckBox.setSelected(task.isTaskCompleted());

        // Save Button to update task details
        saveButton = new Button("Save");
        saveButton.setOnAction(e -> saveTaskDetails());

        // Styling and Spacing
        this.setSpacing(10);
        this.setPadding(new Insets(10));
        this.setAlignment(Pos.CENTER_LEFT);

        // Add elements to the pane
        this.getChildren().addAll(nameField, dueDateField, descriptionField, completedCheckBox, saveButton);
    }

    private void saveTaskDetails() {
        task.setTaskName(nameField.getText());
        task.setTaskDueDate(dueDateField.getText());
        task.setTaskDescription(descriptionField.getText());
        if (completedCheckBox.isSelected()) task.setTaskCompleted();
        else {
            task.setTaskStatus("Pending");
        }
        System.out.println("Task updated: " + task);
    }
}
