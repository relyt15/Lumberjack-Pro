import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class TaskPane extends HBox {
    private Task task;
    private TextField nameField;
    private TextField dueDateField;
    private TextField descriptionField;
    private Label nameLabel;
    private Label dueDateLabel;
    private Label descriptionLabel;
    private CheckBox completedCheckBox;
    private Button saveButton;

    public TaskPane(Task task) {
        this.task = task;
        TaskService taskServ = new TaskService();
        
        // Text field for Task Name
        nameField = new TextField(task.getTaskName());
        nameField.setPromptText("Task Name");

        
        // Label for Task Name
        nameLabel = new Label(task.getTaskName());
        nameLabel.setStyle("-fx-font-weight: bold;");
        

        // Text field for Task Due Date
        dueDateField = new TextField(task.getTaskDueDate());
        dueDateField.setPromptText("Due Date (YYYY-MM-DD)");
        
        // Label for Due Date
        dueDateLabel = new Label("Due: " + task.getTaskDueDate());
        
        // Text field for Task Description
        descriptionField = new TextField(task.getTaskDescription());
        descriptionField.setPromptText("Task Description");        

        // Checkbox for Completion
        completedCheckBox = new CheckBox();
        completedCheckBox.setSelected(task.isTaskCompleted());
        
        // Save Button to update task details
        saveButton = new Button("Save");
        saveButton.setOnAction(e -> saveTaskDetails());

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
        task.setTaskDueDate(dueDateField.getText());
        task.setTaskDescription(descriptionField.getText());
        if (completedCheckBox.isSelected()) {
            task.setTaskCompleted();
        }
        else {
            task.setTaskStatus("Pending");
        }
    }

}




