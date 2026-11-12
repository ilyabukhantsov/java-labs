package org.example.Tools;

import java.io.*;

public class FileStorageService {
    public static void saveObject(String filePath, Object object) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(object);
            System.out.println("Дані успішно збережено у файл: " + filePath);
        } catch (IOException e) {
            System.out.println("Помилка серіалізації: " + e.getMessage());
        }
    }

    public static Object loadObject(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Помилка десеріалізації: " + e.getMessage());
            return null;
        }
    }
}