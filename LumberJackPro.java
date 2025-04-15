import java.util.Optional;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class LumberjackPro extends Application {
    private BorderPane windowContainer;
    private BorderPane greetContainer;
    //private HBox taskContainer;
    private HBox projectContainer;
    
    
    @Override
    public void start(Stage primaryStage) {
        windowContainer = new BorderPane();
        greetContainer = new BorderPane();
        projectContainer = new HBox(20); // Container to hold project panes   
        
        
        Font font = new Font(13); 
        Label greeting = new Label("LUMBERJACK PRO");
        greeting.setFont(new Font("Liberation Mono", 24));
        GridPane.setHalignment (greeting, HPos.LEFT);
       
        //------------------------------------------------------------------------------------------------
        // initializing buttons and linking their event actions
        //------------------------------------------------------------------------------------------------
        Button addProjectButton = new Button("+ New Project");

        //addTaskButton.setOnAction(e -> addNewTask());  // Handle addTask button click
        addProjectButton.setOnAction (e -> addNewProject()); // handles addProject button click
        //------------------------------------------------------------------------------------------------
        // setting up logo on main page
        //------------------------------------------------------------------------------------------------
        Image tree2 = new Image(getClass().getResourceAsStream("/Illustration19.png"));
        ImageView treeImageView = new ImageView(tree2);
        
        treeImageView.setFitWidth(200);  // Adjust width of the image
        treeImageView.setFitHeight(200); // Adjust height of the image
        treeImageView.setPreserveRatio(true);
        
        VBox greetLayout = new VBox(15, greeting, treeImageView);
        greetLayout.setAlignment(Pos.CENTER);
        greetLayout.setStyle("-fx-padding: 5 px;");
        
        //------------------------------------------------------------------------------------------------
        // setting up the panes to go in the scene
        //------------------------------------------------------------------------------------------------
        HBox projectLayout = new HBox(30, addProjectButton, projectContainer);
//        GridPane layout2 = new GridPane();
//        
//        layout2.add(addProjectButton, 0, 0);
//        layout2.add(projectContainer, 0, 1);
//        layout2.setHgap(30);
        
        //Scrollbar made for Project Section
        ScrollPane scroll2 = new ScrollPane(); 
        scroll2.setContent(projectLayout);
        
        windowContainer.setCenter(scroll2); 
        greetContainer.setTop(greetLayout);
        
        windowContainer.setStyle("-fx-border-color: darkgreen; -fx-border-width: 5px; -fx-border-radius: 10px;");

        
        VBox wholeLayout = new VBox(20, greetContainer, windowContainer);
        wholeLayout.setAlignment(Pos.TOP_CENTER);
        wholeLayout.setStyle("-fx-background-color: beige; -fx-padding: 20px;");
        
        //-------------------------------------------------------------------------------------
        // setting up scene
        //-------------------------------------------------------------------------------------
        Scene scene = new Scene(wholeLayout, 1200, 600, Color.BEIGE);
        
        Image tree = new Image(getClass().getResourceAsStream("/LUMBER.png"));
        primaryStage.getIcons().add(tree);
        
        primaryStage.setTitle("LumberJack Pro");
        primaryStage.setResizable(true);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void addNewProject() {
        // Prompt dialogue box first from project service
        // information entered into dialogue box gets set to project info
        // then the project pane accepts the info from the project into LABELS instead of textfields
        ProjectService man1 = new ProjectService();
        Optional<Project> result = man1.newProjectDialog();

        result.ifPresent(project -> {
            // This block only runs if the user clicked OK and a project was created
            ProjectPane projectPane = new ProjectPane(project);
            projectContainer.getChildren().add(projectPane);
        });
        
    }

    public static void main(String[] args) {
        launch(args);
    }
}
