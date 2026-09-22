package tn.esprit;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello DevOps CI!");
        System.out.println("Addition: " + add(3, 4));
        System.out.println("Multiplication: " + multiply(3, 4));
        System.out.println("Factorielle de 5: " + factorial(5));
        System.out.println("Est pair (4): " + isEven(4));
        System.out.println("Max(3, 7): " + max(3, 7));
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static int factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("n doit être positif");
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }

    public static boolean isEven(int n) {
        return n % 2 == 0;
    }

    public static int max(int a, int b) {
        return (a > b) ? a : b;
    }
}
