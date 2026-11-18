package org.example.Task2;

public class Triangle extends Shape {
    private static final long serialVersionUID = 1L;
    private double base;
    private double height;

    public Triangle(String color, double base, double height) {
        super(color);
        this.base = base;
        this.height = height;
    }

    @Override
    public double getArea() { return 0.5 * base * height; }
}