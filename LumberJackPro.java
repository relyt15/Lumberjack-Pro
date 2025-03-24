package com.mycompany.lumberjack_pro;

//import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class LumberJackPro extends Application {
    private BorderPane windowContainer;
    private HBox taskContainer;
    private HBox projectContainer;
    
    
    @Override
    public void start(Stage primaryStage) {
        windowContainer = new BorderPane();
        taskContainer = new HBox(10);  // Container to hold task panes
        projectContainer = new HBox(20); // Container to hold project panes   
     
        
        Font font = new Font(13); 
        Label greeting = new Label("What Are Your Plans for Today?");
        greeting.setFont(font);
        GridPane.setHalignment (greeting, HPos.LEFT);
        
        Button addTaskButton = new Button("Add New Task");
        Button addProjectButton = new Button("Add New Project");

        addTaskButton.setOnAction(e -> addNewTask());  // Handle addTask button click
        addProjectButton.setOnAction (e -> addNewProject()); // handles addProject button click
        
        VBox taskLayout = new VBox(20, addTaskButton, taskContainer);  // Overall layout
        HBox projectLayout = new HBox(30, addProjectButton, projectContainer);
        
        windowContainer.setBottom(taskLayout);
        windowContainer.setCenter(projectLayout);
        
        
        Group root = new Group(greeting, windowContainer); //taskLayout, projectLayout
        Scene scene = new Scene(root, 1200, 600, Color.BEIGE);
        
        Image tree = new Image(getClass().getResourceAsStream("/LUMBER.png"));
        primaryStage.getIcons().add(tree);
        
        primaryStage.setTitle("LumberJack Pro");
        primaryStage.setResizable(false);
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
