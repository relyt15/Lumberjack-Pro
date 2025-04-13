import java.time.LocalDate;
import java.util.Optional;
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
import javafx.scene.layout.HBox;

public class TaskPane extends HBox {
    private Task task;
    private TextField nameField;
    private DatePicker dueDateField;
    private TextField descriptionField;
    private Label nameLabel;
    private Label descriptionLabel;
    private Label dueDateLabel;
    private CheckBox completedCheckBox;
    private Button saveButton;
    private Label status;
    private Button editTaskButton;

    public TaskPane(Task task) {
        this.task = task;
        TaskService taskServ = new TaskService();
        
        // Label for Task Name
        nameLabel = new Label("Task: " + task.getTaskName());
        nameLabel.setStyle("-fx-font-weight: bold;");
        nameLabel.setAlignment(Pos.CENTER);
        
        
        //Label for Due Date
        dueDateLabel = new Label("Due Date: " + task.getTaskDueDate());
        
        // Label for task description
        descriptionLabel = new Label("Description: " + task.getTaskDescription());
        

        // Checkbox for Completion
        completedCheckBox = new CheckBox();
        completedCheckBox.setSelected(task.isTaskCompleted());
        
        
        
        // Save Button to update task details
        saveButton = new Button("Save");
        saveButton.setOnAction(e -> descriptionField.setEditable(false));
        saveButton.setOnAction(e -> dueDateField.setEditable(false));
        saveButton.setOnAction(e -> nameField.setEditable(false));

        editTaskButton = new Button("Edit");
        editTaskButton.setOnAction(e -> editTaskDetails());
        
        
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
        this.getChildren().addAll(nameLabel, descriptionLabel, dueDateLabel,
                completedCheckBox, editTaskButton);
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
    
    private void editTaskDetails() {
        TaskService man1 = new TaskService();
        
        Optional<Task> result = man1.editTaskDialog(task);
        result.ifPresent(updated -> {
            // Update the local project reference
            task = updated;

            // Update UI labels
            nameLabel.setText("Task: " + task.getTaskName());
            dueDateLabel.setText("Due Date: " + task.getTaskDueDate());
            descriptionLabel.setText("Description: " + task.getTaskDescription());
        });
    }


}
