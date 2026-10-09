package com.example;

import java.util.Arrays;

public class ShapeController {
    private Shape[] shapes;
    private ShapeView view;

    public ShapeController(Shape[] shapes, ShapeView view) {
        this.shapes = shapes;
        this.view = view;
    }

    public void execute() {
        view.printShapes(shapes, "shape array: ");

        double totalArea = calculateTotalArea();
        view.printTotalArea(totalArea);

        double rectangleArea = calculateTotalAreaByClass(Rectangle.class);
        view.printAreaByShapeType(Rectangle.class, rectangleArea);

        double triangleArea = calculateTotalAreaByClass(Triangle.class);
        view.printAreaByShapeType(Triangle.class, triangleArea);

        double circleArea = calculateTotalAreaByClass(Circle.class);
        view.printAreaByShapeType(Circle.class, circleArea);

        sortByArea();
        view.printShapes(shapes, "sorted by area size");

        sortByColor();
        view.printShapes(shapes, "sorted by color");
    }

    public double calculateTotalArea() {
        double total = 0;
        for (Shape shape : shapes) {
            total += shape.calcArea();
        }
        return total;
    }

    public double calculateTotalAreaByClass(Class<?> shapeClass) {
        double total = 0;
        for (Shape shape : shapes) {
            if (shapeClass.isInstance(shape)) {
                total += shape.calcArea();
            }
        }
        return total;
    }

    public void sortByArea() {
        Arrays.sort(shapes, new AreaComparator());
    }

    public void sortByColor() {
        Arrays.sort(shapes, new ColorComparator());
    }
}



/*
<-                  
controller -> model -> view 
*/