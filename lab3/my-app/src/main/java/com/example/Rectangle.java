package com.example;

class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(String shapeColor, double width, double height) {
        super(shapeColor);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("Rectangle with " + getShapeColor() + " color");
    }

    @Override
    public double calcArea() {
        return width * height;
    }
}
