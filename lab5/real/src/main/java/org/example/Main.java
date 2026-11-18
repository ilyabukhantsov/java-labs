package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter file path:");
        String filePath = scanner.nextLine();

        FileStorageService.saveObject(filePath, results);
    }
}
