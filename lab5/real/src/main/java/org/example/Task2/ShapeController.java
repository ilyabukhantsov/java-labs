package org.example.Task2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ShapeController {

    private Shape[] shapes;
    private final ShapeView view;
    private final Scanner scanner = new Scanner(System.in);

    public ShapeController(Shape[] shapes, ShapeView view) {
        this.shapes = shapes;
        this.view = view;
    }

    public void execute() {
        boolean running = true;
        while (running) {
            printMenu();
            int choice = readInt("Ваш вибір: ");
            switch (choice) {
                case 1: view.printShapes(shapes, "Фігури:"); break;
                case 2: totalArea();     break;
                case 3: areaByType();    break;
                case 4: searchByColor(); break;
                case 5: saveToFile();    break;
                case 6: loadFromFile();  break;
                case 0: running = false; break;
                default: view.printMessage("Немає такого пункту меню.");
            }
        }
        view.printMessage("Вихід.");
    }

    private void printMenu() {
        System.out.println("\n===== МЕНЮ =====");
        System.out.println("1. Показати всі фігури");
        System.out.println("2. Загальна площа");
        System.out.println("3. Площа за типом фігури");
        System.out.println("4. Пошук за кольором");
        System.out.println("5. Зберегти у файл");
        System.out.println("6. Завантажити з файлу");
        System.out.println("0. Вихід");
    }

    // ---------- команди ----------

    private void totalArea() {
        double sum = 0;
        for (Shape s : shapes) {
            sum += s.getArea();
        }
        view.printTotalArea(sum);
    }

    private void areaByType() {
        System.out.print("Тип (Circle / Triangle / Rectangle): ");
        String name = scanner.nextLine().trim().toLowerCase();
        Class<?> type;
        switch (name) {
            case "circle":    type = Circle.class;    break;
            case "triangle":  type = Triangle.class;  break;
            case "rectangle": type = Rectangle.class; break;
            default:
                view.printMessage("Невідомий тип фігури.");
                return;
        }
        double sum = 0;
        for (Shape s : shapes) {
            if (type.isInstance(s)) {
                sum += s.getArea();
            }
        }
        view.printAreaByShapeType(type, sum);
    }

    /** Дані для пошуку вводяться з клавіатури. */
    private void searchByColor() {
        System.out.print("Введіть колір для пошуку: ");
        String color = scanner.nextLine().trim();
        if (color.isEmpty()) {
            view.printMessage("Порожній запит.");
            return;
        }
        boolean found = false;
        for (Shape s : shapes) {
            if (s.getColor().equalsIgnoreCase(color)) {
                view.printMessage(s.toString());
                found = true;
            }
        }
        if (!found) {
            view.printMessage("Нічого не знайдено.");
        }
    }

    private void saveToFile() {
        try {
            File file = askFile();
            ShapeStorage.save(file, shapes);
            view.printMessage("Збережено: " + file.getAbsolutePath());
        } catch (IllegalArgumentException e) {
            view.printMessage("Некоректний шлях: " + e.getMessage());
        } catch (IOException e) {
            view.printMessage("Помилка запису: " + e.getMessage());
        }
    }

    private void loadFromFile() {
        try {
            File file = askFile();
            shapes = ShapeStorage.load(file);
            view.printMessage("Завантажено фігур: " + shapes.length);
        } catch (IllegalArgumentException e) {
            view.printMessage("Некоректний шлях: " + e.getMessage());
        } catch (ClassNotFoundException | ClassCastException e) {
            view.printMessage("Файл має невірний формат.");
        } catch (IOException e) {
            view.printMessage("Помилка читання: " + e.getMessage());
        }
    }

    // ---------- ввод ----------

    private File askFile() {
        System.out.print("Папка (Enter = поточна): ");
        String dir = scanner.nextLine();
        System.out.print("Ім'я файлу (наприклад shapes.bin): ");
        String name = scanner.nextLine();
        return ShapeStorage.buildFile(dir, name);
    }

    private int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Потрібне ціле число. Спробуйте ще раз.");
            }
        }
    }
}