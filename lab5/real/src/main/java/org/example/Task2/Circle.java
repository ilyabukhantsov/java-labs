package org.example.Task2;

public class Circle extends Shape {
    private static final long serialVersionUID = 1L;
    private double radius;

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public double getArea() { return Math.PI * radius * radius; }
}