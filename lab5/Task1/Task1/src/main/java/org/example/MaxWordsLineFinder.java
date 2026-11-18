package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MaxWordsLineFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть шлях до файлу: ");
        String filePath = scanner.nextLine();

        String maxLine = "";
        int maxWordCount = -1;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                // Видаляємо зайві пробіли та розбиваємо рядок на слова за допомогою регулярного виразу
                String trimmed = currentLine.trim();
                if (trimmed.isEmpty()) {
                    continue;
                }

                String[] words = trimmed.split("\\s+");
                if (words.length > maxWordCount) {
                    maxWordCount = words.length;
                    maxLine = currentLine;
                }
            }

            if (maxWordCount == -1) {
                System.out.println("Файл виявився порожнім.");
            } else {
                System.out.println("\nРядок із максимальною кількістю слів (" + maxWordCount + " слів):");
                System.out.println(maxLine);
            }

        } catch (IOException e) {
            System.out.println("Помилка при читанні файлу: " + e.getMessage());
        }
    }
}