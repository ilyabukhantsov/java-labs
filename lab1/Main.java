import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        CountSuperPrimeNumbers countSuperPrimeNumbers = new CountSuperPrimeNumbers();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Type your Number: ");
        int number = scanner.nextInt();

        try {
            int result = countSuperPrimeNumbers.countSuperPrime(number);
            System.out.println("Answer: " + result); 
        } catch (IllegalArgumentException exception){
            System.err.println("Error: illigal number");
            scanner.close();
            return;
        }

        scanner.close();
    }
}