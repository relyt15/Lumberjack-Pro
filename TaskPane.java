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
import javafx.scene.text.Text;


public class TaskPane extends HBox {
    private Task task;
    private TextField nameField;
    private DatePicker dueDateField;
    private TextField descriptionField;
    private Text nameLabel;
    private Text descriptionLabel;
    private Text dueDateLabel;
    private CheckBox completedCheckBox;
    private Button saveButton;
    private Label status;
    private Button editTaskButton;
    private Button undoTaskButton;

    public TaskPane(Task task, Project proj, VBox taskListContainer) {
        this.task = task;
        TaskService taskServ = new TaskService();

      
        this.setStyle("-fx-border-color: gray; -fx-border-width: 2px; -fx-border-radius: 5px; -fx-padding: 10px;");
        
        // Label for Task Name
        nameLabel = new Text("Task: " + task.getTaskName());
        nameLabel.setStyle("-fx-font-weight: bold;");
        this.setAlignment(Pos.CENTER_LEFT);
        
        
        //Label for Due Date
        dueDateLabel = new Text("Due Date: " + task.getTaskDueDate());
        
        // Label for task description
        descriptionLabel = new Text("Description: " + task.getTaskDescription());

        

        // Checkbox for Strikethrough Completion
        completedCheckBox = new CheckBox();
        completedCheckBox.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {
            descriptionLabel.setStrikethrough(isNowSelected);
            dueDateLabel.setStrikethrough(isNowSelected);
            nameLabel.setStrikethrough(isNowSelected);

        });
        
        
        // Save Button to update task details
        saveButton = new Button("Save");
        saveButton.setOnAction(e -> descriptionField.setEditable(false));
        saveButton.setOnAction(e -> dueDateField.setEditable(false));
        saveButton.setOnAction(e -> nameField.setEditable(false));

        editTaskButton = new Button("Edit");
        editTaskButton.setOnAction(e -> editTaskDetails());


	undoTaskButton = new Button("Delete");        
        undoTaskButton.setOnAction(e -> {
        taskListContainer.getChildren().remove(this); // remove from UI
        proj.removeTaskFromProject(task); // remove from model
        taskServ.removeTask(task); // remove from persistent storage
    	});
      

        // Styling and Spacing
        this.setSpacing(15);
        this.setPadding(new Insets(10));
        this.setAlignment(Pos.CENTER_LEFT);

        // Add elements to the pane
        this.getChildren().addAll(nameLabel, descriptionLabel, dueDateLabel,
                completedCheckBox, editTaskButton, undoTaskButton);
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
