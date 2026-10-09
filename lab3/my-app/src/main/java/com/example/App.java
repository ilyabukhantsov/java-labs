package com.example;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Shape[] shapes = ShapeRepository.generateShapes(10);

        ShapeView view = new ShapeView();
        ShapeController controller = new ShapeController(shapes, view);

        controller.execute();
    }
}