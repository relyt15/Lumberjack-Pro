import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LumberjackPro extends Application {
    private BorderPane windowContainer;
    private VBox taskContainer;
    private HBox projectContainer;
    
    
    @Override
    public void start(Stage primaryStage) {
        windowContainer = new BorderPane();
        taskContainer = new VBox(10);  // Container to hold task panes
        projectContainer = new HBox(20); // Container to hold project panes
        
        Button addTaskButton = new Button("Add New Task");
        Button addProjectButton = new Button("Add New Project");

        addTaskButton.setOnAction(e -> addNewTask());  // Handle addTask button click
        addProjectButton.setOnAction (e -> addNewProject()); // handles addProject button click

        
        VBox taskLayout = new VBox(10, addTaskButton, taskContainer);  // Overall layout
        HBox projectLayout = new HBox(20, addProjectButton, projectContainer);
        
        windowContainer.setBottom(taskLayout);
        windowContainer.setCenter(projectLayout);
        
        Group root = new Group(windowContainer); //taskLayout, projectLayout
        Scene scene = new Scene(root, 300, 400);
        
        primaryStage.setTitle("Task Manager");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void addNewTask() {
        // Create new Task object (you can later gather this from user input)
        Task newTask = new Task();
        
        // Create TaskPane and add to the layout
        TaskPane taskPane = new TaskPane(newTask);
        taskContainer.getChildren().add(taskPane);
    }
    private void addNewProject() {
        Project newProject = new Project();
        
        //Create ProjectPane and adds to the layout
        ProjectPane projectPane = new ProjectPane(newProject);
        projectContainer.getChildren().add(projectPane);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
