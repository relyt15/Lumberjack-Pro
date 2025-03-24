package com.mycompany.lumberjack_pro;

import java.time.LocalDate;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;

public class TaskPane extends VBox {
    private Task task;
    private TextField nameField;
    private DatePicker dueDateField;
    private TextField descriptionField;
    private Label nameLabel;
    private Label descriptionLabel;
    private CheckBox completedCheckBox;
    private Button saveButton;
    private Label status;

    public TaskPane(Task task) {
        this.task = task;
        TaskService taskServ = new TaskService();
        
        // Text field for Task Name
        nameField = new TextField(task.getTaskName());
        nameField.setPromptText("Task Name");
        nameField.setAlignment(Pos.CENTER);
        

        // Label for Task Name
        nameLabel = new Label(task.getTaskName());
        nameLabel.setStyle("-fx-font-weight: bold;");
        
        // Text field for Task Due Date
        dueDateField = new DatePicker(LocalDate.now());
        dueDateField.setOnAction(this::processDateChoice);
        
        // Text field for Task Description
        descriptionField = new TextField(task.getTaskDescription());
        descriptionField.setAlignment(Pos.CENTER);
        descriptionField.setPromptText("Task Description");   
        

        // Checkbox for Completion
        completedCheckBox = new CheckBox();
        completedCheckBox.setSelected(task.isTaskCompleted());
        
        
        
        // Save Button to update task details
        saveButton = new Button("Save");
        saveButton.setOnAction(e -> descriptionField.setEditable(false));
        saveButton.setOnAction(e -> dueDateField.setEditable(false));
        saveButton.setOnAction(e -> nameField.setEditable(false));

        
        
        // Update Task when checkbox is clicked
        completedCheckBox.setOnAction(e -> {
            if (completedCheckBox.isSelected()) {
                task.setTaskCompleted(); // Mark task as completed
                taskServ.removeTask(task);
            } else {
                task.setTaskStatus("pending"); // Set status back to pending.
            }
        });

        // Styling and Spacing
        this.setSpacing(15);
        this.setPadding(new Insets(10));
        this.setAlignment(Pos.CENTER_LEFT);

        // Add elements to the pane
        this.getChildren().addAll(nameField, dueDateField, descriptionField,
                completedCheckBox, saveButton);
    }
    
    private void saveTaskDetails() {
        task.setTaskName(nameField.getText());
        task.setTaskDescription(descriptionField.getText());
        if (completedCheckBox.isSelected()) {
            task.setTaskCompleted();
        }
        else {
            task.setTaskStatus("Pending");
        }
    }

    private void processDateChoice(ActionEvent t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
