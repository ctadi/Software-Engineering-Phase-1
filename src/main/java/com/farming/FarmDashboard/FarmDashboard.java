package com.farming.FarmDashboard;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class FarmDashboard extends Application {

    private static FarmDashboard instance;

    public static synchronized FarmDashboard getInstance() {
        if (instance == null) {
            instance = new FarmDashboard();
        }
        return instance;
    }



    @Override
    public void start(Stage primaryStage) {
        // Create the main dashboard pane
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 800, 600);

        //  a background image for the dashboard
        Image backgroundImage = new Image(getClass().getResourceAsStream("/background.png"));
        ImageView backgroundImageView = new ImageView(backgroundImage);

        //  title section at the top
        HBox titleBox = new HBox();
        titleBox.setStyle("-fx-background-color: #99cc99; -fx-padding: 10;");
        titleBox.getChildren().add(new ImageView(new Image(getClass().getResourceAsStream("/background.png"))));
        titleBox.getChildren().add(new javafx.scene.control.Label("My Farm Dashboard"));
        root.setTop(titleBox);

        // Create a grid for buttons
        GridPane buttonGrid = new GridPane();
        buttonGrid.setHgap(10);
        buttonGrid.setVgap(10);

        //  buttons for different sections
        Button itemButton = createButton("Item/Item Container");
        Button droneButton = createButton("Drone Actions");
        Button visualizationButton = createButton("Visualization");

        // Handle button actions
        itemButton.setOnAction(e -> handleItemButtonClick());
        droneButton.setOnAction(e -> handleDroneButtonClick());
        visualizationButton.setOnAction(e -> handleVisualizationButtonClick());

        // Add the buttons to the grid
        buttonGrid.add(itemButton, 0, 0);
        buttonGrid.add(droneButton, 0, 1);
        buttonGrid.add(visualizationButton, 0, 2);

        // Set the grid in the center of the dashboard
        root.setCenter(buttonGrid);

        // Add a background image
        BackgroundImage bgImage = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        root.setBackground(new Background(bgImage));

        primaryStage.setScene(scene);
        primaryStage.setTitle("Farm Dashboard");
        primaryStage.show();
    }

    private Button createButton(String text) {
        Button button = new Button(text);
        button.setStyle("-fx-font-size: 16; -fx-padding: 10;");
        return button;
    }

    private void handleItemButtonClick() {
        // Create a new ItemContainer
        ItemContainer itemContainer = new ItemContainer("New Item Container");
        itemContainer.setupUI(); // Initialize the UI of the itemContainer
        // Add other necessary operations here
        System.out.println("Item/Item Container section clicked.");
    }


    private void handleDroneButtonClick() {
        // Implement the action when the Drone Actions button is clicked
        Drone.getInstance().animateFlightTo(new ItemContainer("New Item Container"));
        System.out.println("Drone Actions section clicked.");
    }

    private void handleVisualizationButtonClick() {
        // Implement the action when the Visualization button is clicked
        System.out.println("Visualization section clicked.");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
