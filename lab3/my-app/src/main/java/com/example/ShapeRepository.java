package com.example;

import java.util.Random;

public class ShapeRepository {
    private static final String[] COLORS_CONST = {"Червоний", "Синій", "Зелений", "Жовтий", "Білий", "Чорний"};

    public static Shape[] generateShapes(int count) {
        Shape[] shapes = new Shape[count];
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            int shapeType = random.nextInt(3);
            String color = COLORS_CONST[random.nextInt(COLORS_CONST.length)];


            switch (shapeType) {
                case 0:
                    double radius = 1 + random.nextDouble() * 10;
                    shapes[i] = new Circle(color, radius);
                    break;
                case 1:
                    double base = 1 + random.nextDouble() * 10;
                    double tHeight = 1 + random.nextDouble() * 10;
                    shapes[i] = new Triangle(color, base, tHeight);
                    break;
                case 2:
                    double width = 1 + random.nextDouble() * 10;
                    double height = 1 + random.nextDouble() * 10;
                    shapes[i] = new Rectangle(color, width, height);
                    break;
            }
        }
        return shapes;
    }
}
