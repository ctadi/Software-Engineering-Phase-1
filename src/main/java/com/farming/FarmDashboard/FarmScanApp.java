package com.farming.FarmDashboard;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FarmScanApp extends Application {

    private Label scanResultsLabel; // Assuming you have a label for displaying scan results

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Farm Scan App");

        scanResultsLabel = new Label("Scan Results: "); // Initialize the label

        VBox root = new VBox(10);
        root.getChildren().addAll(scanResultsLabel);

        Scene scene = new Scene(root, 300, 200);
        primaryStage.setScene(scene);

        primaryStage.show();

        // Simulate a farm scan completion
        completeFarmScan();
    }

    private void completeFarmScan() {
        // Simulate getting scan results
        String scanResults = "Scanned 20 cows, 100 acres of crops, and 3 barns.";

        // Call the method to update the GUI component with scan results
        updateGUIComponentWithScanResults(scanResults);
    }

    private void updateGUIComponentWithScanResults(String scanResults) {
        // Update the label with the scan results
        scanResultsLabel.setText("Scan Results: " + scanResults);
    }


}
