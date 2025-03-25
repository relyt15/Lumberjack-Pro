package com.mycompany.lumberjack_pro;

//import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
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
    private BorderPane greetContainer;
    private HBox taskContainer;
    private HBox projectContainer;
    
    
    @Override
    public void start(Stage primaryStage) {
        windowContainer = new BorderPane();
        greetContainer = new BorderPane();
        taskContainer = new HBox(10);  // Container to hold task panes
        projectContainer = new HBox(20); // Container to hold project panes   
     
        
        Font font = new Font(13); 
        Label greeting = new Label("Welcome Lumberman, What Are Yer Plans for Today?");
        greeting.setFont(new Font("Liberation Mono", 24));
        GridPane.setHalignment (greeting, HPos.LEFT);
       
        
        Button addTaskButton = new Button("+");
        Button addProjectButton = new Button("Add New Project");

        addTaskButton.setOnAction(e -> addNewTask());  // Handle addTask button click
        addProjectButton.setOnAction (e -> addNewProject()); // handles addProject button click
        
        VBox greetLayout = new VBox(15, greeting);
        greetLayout.setAlignment(Pos.CENTER);
        greetLayout.setStyle("-fx-padding: 5 px;");
        
        VBox taskLayout = new VBox(20, addTaskButton, taskContainer);  // Overall layout
        HBox projectLayout = new HBox(30, addProjectButton, projectContainer);
        
        ScrollPane scroll = new ScrollPane(); //Scrollbar made for Task Sections
        scroll.setContent(taskLayout);
        
        ScrollPane scroll2 = new ScrollPane(); //Scrollbar made for Project Section
        scroll2.setContent(projectLayout);
        
        windowContainer.setBottom(scroll); 
        windowContainer.setCenter(scroll2); 
        greetContainer.setTop(greetLayout);
        
        windowContainer.setStyle("-fx-border-color: darkgreen; -fx-border-width: 5px; -fx-border-radius: 10px;");

        
        VBox wholeLayout = new VBox(20, greetContainer, windowContainer);
        wholeLayout.setAlignment(Pos.TOP_CENTER);
        wholeLayout.setStyle("-fx-background-color: beige; -fx-padding: 20px;");
        
        
        Scene scene = new Scene(wholeLayout, 1200, 600, Color.BEIGE);
        
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
