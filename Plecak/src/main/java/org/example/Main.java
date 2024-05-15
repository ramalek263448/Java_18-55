package org.example;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        int seed;
        int cap;

        do {
            System.out.println(STR."Please enter the number of items:\{System.lineSeparator()}");
            n = scanner.nextInt();
        } while (n <= 0);

        do {
            System.out.println(STR."Please enter the seed:\{System.lineSeparator()}");
            seed = scanner.nextInt();
        } while (seed <= 0);

        Problem problem = new Problem(n, seed, 1, 10);
        System.out.println(problem);

        do {
            System.out.println(STR."Please enter the capacity:\{System.lineSeparator()}");
            cap = scanner.nextInt();
        } while (cap <= 0);

        System.out.println(problem.Solve(cap));
        scanner.close();


    }
}