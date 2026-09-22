package tn.esprit;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello DevOps CI!");
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
