package com.farming.FarmDashboard;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class Item extends FarmComponent {
    private TextField nameField;
    private TextField priceField;
    private TextField locationXField;
    private TextField locationYField;
    private TextField lengthField;
    private TextField widthField;
    private TextField heightField;
    private ItemContainer parentContainer;
    private Pane root;

    public Item(String name) {
        super();
        this.name = name;
        this.root = root;
        setupUI();
    }

    private void setupUI() {
        nameField = new TextField(name);
        priceField = new TextField(Double.toString(price));
        locationXField = new TextField(Double.toString(locationX));
        locationYField = new TextField(Double.toString(locationY));
        lengthField = new TextField(Double.toString(length));
        widthField = new TextField(Double.toString(width));
        heightField = new TextField(Double.toString(height));

        Button deleteItemButton = new Button("Delete Item");
        deleteItemButton.setOnAction(e -> deleteItemButtonClicked());

        Button updatePropertiesButton = new Button("Update Properties");
        updatePropertiesButton.setOnAction(e -> updatePropertiesButtonClicked());

        HBox buttonsHBox = new HBox(deleteItemButton, updatePropertiesButton);

        VBox propertiesVBox = new VBox(nameField, priceField, locationXField, locationYField, lengthField, widthField, heightField);

        VBox itemVBox = new VBox(propertiesVBox, buttonsHBox);
        VBox mainVBox = new VBox(itemVBox);

        nameField.setPromptText("Name");
        priceField.setPromptText("Price");
        locationXField.setPromptText("Location X");
        locationYField.setPromptText("Location Y");
        lengthField.setPromptText("Length");
        widthField.setPromptText("Width");
        heightField.setPromptText("Height");

        mainVBox.setSpacing(10);
        mainVBox.setStyle("-fx-padding: 10;");
        itemVBox.setSpacing(10);
        propertiesVBox.setSpacing(5);
        buttonsHBox.setSpacing(5);

        root.getChildren().add(mainVBox);
    }

    private void deleteItemButtonClicked() {
        if (parentContainer != null) {
            parentContainer.removeItem(this);
            root.getChildren().clear(); // Clear the UI elements of this item
        }
    }

    private void updatePropertiesButtonClicked() {
        name = nameField.getText();
        price = Double.parseDouble(priceField.getText());
        locationX = Double.parseDouble(locationXField.getText());
        locationY = Double.parseDouble(locationYField.getText());
        length = Double.parseDouble(lengthField.getText());
        width = Double.parseDouble(widthField.getText());
        height = Double.parseDouble(heightField.getText());
    }

    @Override
    public void render(Node parent) {
        if (parent instanceof Pane) {
            Pane pane = (Pane) parent;
            pane.getChildren().clear();

            Rectangle itemRect = new Rectangle(locationX, locationY, width, height);
            itemRect.setFill(Color.ORANGE); // Adjust color as needed
            pane.getChildren().add(itemRect);

            Text nameText = new Text(locationX + width / 2, locationY + height + 15, name);
            pane.getChildren().add(nameText);
        } else {
            throw new IllegalArgumentException("Parent should be an instance of Pane");
        }
    }

    public Node getRectangle() {
        Rectangle itemRect = new Rectangle(locationX, locationY, width, height);
        itemRect.setFill(Color.ORANGE); // Adjust color as needed
        return itemRect;
    }
}
