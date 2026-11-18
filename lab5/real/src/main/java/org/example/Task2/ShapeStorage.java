package org.example.Task2;

import java.io.*;

public class ShapeStorage {

    /** Собирает файл из папки и имени, введённых пользователем. */
    public static File buildFile(String directory, String fileName) {
        if (fileName == null || fileName.trim().isEmpty()) {
            throw new IllegalArgumentException("Ім'я файлу не може бути порожнім.");
        }
        File dir = (directory == null || directory.trim().isEmpty())
                ? new File(".")
                : new File(directory.trim());

        if (!dir.exists() && !dir.mkdirs()) {
            throw new IllegalArgumentException("Не вдалося створити папку: " + dir);
        }
        if (!dir.isDirectory()) {
            throw new IllegalArgumentException("Це не папка: " + dir);
        }
        return new File(dir, fileName.trim());
    }

    public static void save(File file, Shape[] shapes) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(file)))) {
            out.writeObject(shapes);
        }
    }

    public static Shape[] load(File file) throws IOException, ClassNotFoundException {
        if (!file.exists() || !file.isFile()) {
            throw new FileNotFoundException("Файл не знайдено: " + file.getAbsolutePath());
        }
        try (ObjectInputStream in = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream(file)))) {
            return (Shape[]) in.readObject();
        }
    }
}