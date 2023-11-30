package com.farming.FarmDashboard;

import javafx.scene.layout.Pane;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Dashboard extends ItemContainer {

    private static Dashboard instance;

    private Dashboard() {
        super("Dashboard");
    }

    public static Dashboard getInstance() {
        if (instance == null) {
            instance = new Dashboard();
        }
        return instance;
    }

    public void render(Pane root) {
        // Clear the root pane before rendering
        root.getChildren().clear();

        // Render the dashboard as a background rectangle
        Rectangle dashboardRect = new Rectangle(0, 0, 800, 600); // Assuming the dashboard size is 800x600
        dashboardRect.setFill(Color.LIGHTBLUE); // Adjust color as needed
        root.getChildren().add(dashboardRect);

        // Render each item-container and item in the dashboard
        super.render(root);
    }
}
