package com.farming.FarmDashboard;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class ItemContainer extends FarmComponent {
    private ArrayList<FarmComponent> items = new ArrayList<>();
    private TextField nameField;
    private TextField priceField;
    private TextField locationXField;
    private TextField locationYField;
    private TextField lengthField;
    private TextField widthField;
    private TextField heightField;
    private ItemContainer parentContainer;
    private Pane root;

    public ItemContainer(String name) {
        this.name = name;
        this.root = root;
        setupUI();
    }

    void setupUI() {
        nameField = new TextField(name);
        priceField = new TextField(Double.toString(price));
        locationXField = new TextField(Double.toString(locationX));
        locationYField = new TextField(Double.toString(locationY));
        lengthField = new TextField(Double.toString(length));
        widthField = new TextField(Double.toString(width));
        heightField = new TextField(Double.toString(height));

        Button addItemContainerButton = new Button("Add Item Container");
        addItemContainerButton.setOnAction(e -> addItemContainerButtonClicked());

        Button addItemButton = new Button("Add Item");
        addItemButton.setOnAction(e -> addItemButtonClicked());

        Button deleteItemContainerButton = new Button("Delete Item Container");
        deleteItemContainerButton.setOnAction(e -> deleteItemContainerButtonClicked());

        Button updatePropertiesButton = new Button("Update Properties");
        updatePropertiesButton.setOnAction(e -> updatePropertiesButtonClicked());

        HBox buttonsHBox = new HBox(addItemContainerButton, addItemButton, deleteItemContainerButton, updatePropertiesButton);
        VBox propertiesVBox = new VBox(nameField, priceField, locationXField, locationYField, lengthField, widthField, heightField);

        VBox containerVBox = new VBox(propertiesVBox, buttonsHBox);
        VBox mainVBox = new VBox(containerVBox);

        nameField.setPromptText("Name");
        priceField.setPromptText("Price");
        locationXField.setPromptText("Location X");
        locationYField.setPromptText("Location Y");
        lengthField.setPromptText("Length");
        widthField.setPromptText("Width");
        heightField.setPromptText("Height");

        mainVBox.setSpacing(10);
        mainVBox.setStyle("-fx-padding: 10;");
        containerVBox.setSpacing(10);
        propertiesVBox.setSpacing(5);
        buttonsHBox.setSpacing(5);

        root.getChildren().add(mainVBox);
    }

    private void addItemContainerButtonClicked() {
        String newName = nameField.getText();
        ItemContainer newContainer = new ItemContainer(newName);
        items.add(newContainer);
        render(root);
    }

    private void addItemButtonClicked() {
        String newItemName = nameField.getText();
        Item newItem = new Item(newItemName);
        items.add(newItem);
        render(root);
    }

    private void deleteItemContainerButtonClicked() {
        if (parentContainer != null) {
            parentContainer.removeItem(this);
            root.getChildren().clear(); // Clear the UI elements of this item container
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
    public void setParentContainer(ItemContainer container) {
        parentContainer = container;
    }

    @Override
    public void render(Node parent) {
        if (parent instanceof Pane) {
            Pane pane = (Pane) parent;
            pane.getChildren().clear();

            Rectangle containerRect = new Rectangle(locationX, locationY, width, height);
            containerRect.setFill(Color.LIGHTGREEN); // Adjust color as needed
            pane.getChildren().add(containerRect);

            Text nameText = new Text(locationX + width / 2, locationY - 10, name);
            pane.getChildren().add(nameText);

            for (FarmComponent item : items) {
                item.render(pane); // Render each item within the container
            }
        } else {
            throw new IllegalArgumentException("Parent should be an instance of Pane");
        }
    }

    @Override
    public void addItem(FarmComponent component) {
        items.add(component);
        component.setParentContainer(this);
    }

    @Override
    public void removeItem(FarmComponent component) {
        items.remove(component);
    }



    public Node getRectangle() {
        return null;
    }

    public void add(Item item) {

    }

    public void initializeUI() {
        root = new Pane();
        // You can add any additional setup for the root here if needed.
    }



}
