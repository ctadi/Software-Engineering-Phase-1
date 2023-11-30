package com.farming.FarmDashboard;

import javafx.scene.Node;

public abstract class FarmComponent {
    protected String name;
    protected double price;
    protected double locationX;
    protected double locationY;
    protected double length;
    protected double width;
    protected double height;

    public FarmComponent(String name, double price, double locationX, double locationY, double length, double width, double height) {
        this.name = name;
        this.price = price;
        this.locationX = locationX;
        this.locationY = locationY;
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public FarmComponent() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getLocationX() {
        return locationX;
    }

    public void setLocationX(double locationX) {
        this.locationX = locationX;
    }

    public double getLocationY() {
        return locationY;
    }

    public void setLocationY(double locationY) {
        this.locationY = locationY;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public abstract void render(Node parent);

    public void addItem(FarmComponent component) {
        throw new UnsupportedOperationException();
    }

    public void removeItem(FarmComponent component) {
        throw new UnsupportedOperationException();
    }

    protected void setParentContainer(ItemContainer itemContainer) {

    }
}
