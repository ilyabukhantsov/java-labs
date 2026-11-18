
package org.example.Task1;

import org.example.Tools.AnalysisResult;
import org.example.Tools.FileStorageService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaxWordsLineFinder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<AnalysisResult> results = new ArrayList<>();

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Find line with maximum words");
            System.out.println("2. Save results");
            System.out.println("3. Load results");
            System.out.println("4. Exit");
            System.out.print("Choose: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Enter file path: ");
                        String inputPath = scanner.nextLine();

                        String maxLine = "";
                        int maxWordCount = -1;

                        try (BufferedReader reader =
                                     new BufferedReader(new FileReader(inputPath))) {

                            String currentLine;

                            while ((currentLine = reader.readLine()) != null) {
                                String trimmed = currentLine.trim();

                                if (trimmed.isEmpty()) {
                                    continue;
                                }

                                int wordCount = trimmed.split("\\s+").length;

                                if (wordCount > maxWordCount) {
                                    maxWordCount = wordCount;
                                    maxLine = currentLine;
                                }
                            }

                            if (maxWordCount == -1) {
                                System.out.println("File is empty.");
                            } else {
                                System.out.println("Maximum words: " + maxWordCount);
                                System.out.println(maxLine);

                                results.add(new AnalysisResult(
                                        inputPath,
                                        maxLine,
                                        maxWordCount
                                ));
                            }

                        } catch (IOException e) {
                            System.out.println("File error: " + e.getMessage());
                        }
                        break;

                    case 2:
                        System.out.print("Enter save file path: ");
                        String savePath = scanner.nextLine();

                        FileStorageService.saveObject(savePath, results);
                        break;

                    case 3:
                        System.out.print("Enter load file path: ");
                        String loadPath = scanner.nextLine();

                        Object loaded = FileStorageService.loadObject(loadPath);

                        if (loaded instanceof List<?>) {
                            List<?> loadedList = (List<?>) loaded;

                            boolean valid = true;
                            for (Object item : loadedList) {
                                if (!(item instanceof AnalysisResult)) {
                                    valid = false;
                                    break;
                                }
                            }

                            if (valid) {
                                results.clear();

                                for (Object item : loadedList) {
                                    results.add((AnalysisResult) item);
                                }

                                System.out.println("Results loaded!");

                                for (AnalysisResult result : results) {
                                    System.out.println(result);
                                }
                            } else {
                                System.out.println("Invalid file data.");
                            }
                        } else if (loaded != null) {
                            System.out.println("Invalid file format.");
                        }
                        break;

                    case 4:
                        return;

                    default:
                        System.out.println("Invalid menu option.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }
    }
}
