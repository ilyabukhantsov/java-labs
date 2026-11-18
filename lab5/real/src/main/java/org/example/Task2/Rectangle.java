package org.example.Task2;

public class Rectangle extends Shape {
    private static final long serialVersionUID = 1L;
    private double width;
    private double height;

    public Rectangle(String color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() { return width * height; }
}