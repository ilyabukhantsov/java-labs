package org.example.Tools;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileStorageService {

    /** Собирает File из папки и имени файла, введённых пользователем. */
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

    /** Зберігає набір об'єктів через ObjectOutputStream. */
    public static void saveObjects(File file, List<AnalysisResult> results) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(file)))) {
            oos.writeObject(new ArrayList<>(results));
        }
    }

    /** Читає набір об'єктів через ObjectInputStream. */
    @SuppressWarnings("unchecked")
    public static List<AnalysisResult> loadObjects(File file)
            throws IOException, ClassNotFoundException {
        if (!file.exists() || !file.isFile()) {
            throw new FileNotFoundException("Файл не знайдено: " + file.getAbsolutePath());
        }
        try (ObjectInputStream ois = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream(file)))) {
            return (List<AnalysisResult>) ois.readObject();
        }
    }
}