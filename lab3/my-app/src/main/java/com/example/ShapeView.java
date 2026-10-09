package com.example;

public class ShapeView {
    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printShapes(Shape[] shapes, String header) {
        System.out.println(header);
        if (shapes == null || shapes.length == 0) {
            return;
        }
        for (Shape shape : shapes) {
            System.out.println(shape.toString());
        }
    }

    public void printTotalArea(double totalArea) {
        System.out.printf("Sum arrea: %.2f\n", totalArea);
    }

    public void printAreaByShapeType(Class<?> shapeType, double totalArea) {
        System.out.printf("Sun area [%s]: %.2f\n", shapeType.getSimpleName(), totalArea);
    }
}