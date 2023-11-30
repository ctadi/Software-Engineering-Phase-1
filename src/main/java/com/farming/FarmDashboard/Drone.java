package com.farming.FarmDashboard;

import javafx.animation.PathTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.util.Duration;

public class Drone {
    private ImageView imageView;
    private Pane root;

    public Drone(Pane root) {
        this.root = root;
        Image image = new Image(getClass().getResourceAsStream("/drone.png"));
        imageView = new ImageView(image);
        root.getChildren().add(imageView);
    }
    private static Drone instance;

    private Drone() {
        // Private constructor to prevent instantiation
    }
    public static synchronized Drone getInstance() {
        if (instance == null) {
            instance = new Drone();
        }
        return instance;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void animateFlightTo(ItemContainer destination) {
        Pane parent = (Pane) imageView.getParent();
        Line flightPath = new Line(imageView.getTranslateX(), imageView.getTranslateY(), destination.locationX, destination.locationY);

        PathTransition pathTransition = new PathTransition();
        pathTransition.setNode(imageView);
        pathTransition.setDuration(Duration.seconds(2)); // Adjust the duration as needed
        pathTransition.setPath(flightPath);
        pathTransition.setOnFinished(event -> {
            // Animation finished
            parent.getChildren().remove(imageView); // Remove the drone from the starting point
            destination.render(parent); // Re-render the destination with the drone
        });

        pathTransition.play();
    }

    public void animateScanFarm(double farmWidth, double farmHeight) {
        Pane parent = (Pane) imageView.getParent();
        Line flightPath = new Line(imageView.getTranslateX(), imageView.getTranslateY(), farmWidth, farmHeight);

        PathTransition pathTransition = new PathTransition();
        pathTransition.setNode(imageView);
        pathTransition.setDuration(Duration.seconds(4)); // Adjust the duration as needed for farm scanning
        pathTransition.setPath(flightPath);
        pathTransition.setOnFinished(event -> {
            // Animation finished
            parent.getChildren().remove(imageView); // Remove the drone from the starting point
            completeFarmScan(); // Additional logic for completing the farm scan
        });

        pathTransition.play();
    }

    public void addBarnToRoot() {
        ItemContainer barn = new ItemContainer("Barn");
        root.getChildren().add(barn.getRectangle());
    }

    public void addLivestockAreaToBarn() {
        ItemContainer livestockArea = new ItemContainer("Livestock Area");
        root.getChildren().add(livestockArea.getRectangle());
    }

    public void addCowToLivestockArea() {
        Item cow = new Item("Cow");
        root.getChildren().add(cow.getRectangle());
    }

    public void addMilkStorageToBarn() {
        Item milkStorage = new Item("Milk Storage");
        root.getChildren().add(milkStorage.getRectangle());
    }

    public void addStorageBuildingToRoot() {
        ItemContainer storageBuilding = new ItemContainer("Storage Building");
        root.getChildren().add(storageBuilding.getRectangle());
    }

    public void addTractorToStorageBuilding() {
        Item tractor = new Item("Tractor");
        root.getChildren().add(tractor.getRectangle());
    }

    public void addTillerToStorageBuilding() {
        Item tiller = new Item("Tiller");
        root.getChildren().add(tiller.getRectangle());
    }

    public void addCommandCenterToRoot() {
        ItemContainer commandCenter = new ItemContainer("Command Center");
        root.getChildren().add(commandCenter.getRectangle());
    }

    public void addDroneToCommandCenter() {
        root.getChildren().add(imageView);
    }

    private void completeFarmScan() {
        System.out.println("Farm scanning is complete.");
    }
}
