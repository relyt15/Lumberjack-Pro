import java.util.Optional;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;


public class TaskPane extends VBox {
    private Task task;
    private Text nameLabel;
    private Text descriptionLabel;
    private Text dueDateLabel;
    private CheckBox completedCheckBox;
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
        
        

        editTaskButton = new Button("Edit");
        editTaskButton.setOnAction(e -> editTaskDetails());


	undoTaskButton = new Button("Delete");        
        undoTaskButton.setOnAction(e -> {
            taskListContainer.getChildren().remove(this); // remove from UI
            proj.removeTaskFromProject(task); // remove from model
            taskServ.removeTask(task); // remove from storage
            });
      

        HBox nameDate = new HBox(nameLabel, dueDateLabel);
        nameDate.setSpacing(10);
        HBox checkEditDelete = new HBox(completedCheckBox, editTaskButton, undoTaskButton);
        checkEditDelete.setSpacing(10);
        
        // Styling and Spacing
        this.setSpacing(5);
        this.setPadding(new Insets(5));
        this.setAlignment(Pos.CENTER_LEFT);

        // Add elements to the pane
        this.getChildren().addAll(nameDate, descriptionLabel,
                checkEditDelete);
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
