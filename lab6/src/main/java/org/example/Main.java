package org.example.Translator;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    private static void addWordFromKeyboard(Translator t) {
        try {
            System.out.print("English word: ");
            String en = scanner.nextLine();
            System.out.print("Ukrainian translation: ");
            String ua = scanner.nextLine();
            t.addWord(en, ua);
            System.out.println("Added. Words in dictionary: " + t.getSize());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void translate(Translator t) {
        System.out.print("Enter a phrase in English: ");
        String phrase = scanner.nextLine();
        String result = t.translate(phrase);
        if (result.isEmpty()) {
            System.out.println("Empty phrase.");
        } else {
            System.out.println("Translation: " + result);
        }
    }

    public static void main(String[] args) {
        Translator translator = new Translator();
        boolean working = true;

        while (working) {
            System.out.println("1. Translate a phrase");
            System.out.println("2. Add a word to the dictionary");
            System.out.println("Anything else: exit");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1": translate(translator);     break;
                case "2": addWordFromKeyboard(translator); break;
                default:  System.out.println("Exit!");
            }
        }
    }
}