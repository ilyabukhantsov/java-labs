package org.example;

import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Type your Number: ");
        int data = scanner.nextInt();

        List<Integer> list = Stream.iterate(1, n -> n <= 1000, n -> n + 1).toList();

        IntPredicate isPrime = number -> number > 1 && number < 1000 &&
                IntStream.rangeClosed(2, (int) Math.sqrt(number))
                        .noneMatch(divisor -> number % divisor == 0);

        IntUnaryOperator reverse = n -> Integer.parseInt(
                new StringBuilder(String.valueOf(n)).reverse().toString()
        );

        IntPredicate checkBoth = isPrime.and(n -> isPrime.test(reverse.applyAsInt(n)));

        List<Integer> result = IntStream.range(data, 1000)
                .filter(checkBoth)
                .boxed()
                .toList();
            System.out.println("Answer: " + result);
    }
}