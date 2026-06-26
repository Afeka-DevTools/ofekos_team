package com.example;

import java.util.List;
import java.util.ArrayList;

public class App {

    public static String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        System.out.println(getGreeting());
    }

    /**
     * Returns the factorial of n.
     * @throws IllegalArgumentException if n < 0
     */
    public static long factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be non-negative");
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }

    /**
     * Returns true if the given string is a palindrome (case-insensitive, ignores spaces).
     */
    public static boolean isPalindrome(String s) {
        if (s == null) return false;
        String cleaned = s.toLowerCase().replaceAll("\\s+", "");
        String reversed = new StringBuilder(cleaned).reverse().toString();
        return cleaned.equals(reversed);
    }

    /**
     * Returns the nth Fibonacci number (0-indexed).
     * fib(0)=0, fib(1)=1, fib(2)=1, ...
     * @throws IllegalArgumentException if n < 0
     */
    public static long fibonacci(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be non-negative");
        if (n == 0) return 0;
        if (n == 1) return 1;
        long a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            long tmp = a + b;
            a = b;
            b = tmp;
        }
        return b;
    }

    /**
     * Returns the maximum value in the list.
     * @throws IllegalArgumentException if list is null or empty
     */
    public static int findMax(List<Integer> list) {
        if (list == null || list.isEmpty())
            throw new IllegalArgumentException("List must not be null or empty");
        int max = list.get(0);
        for (int val : list) {
            if (val > max) max = val;
        }
        return max;
    }

    /**
     * Reverses the words in a sentence.
     * e.g. "Hello World" -> "World Hello"
     */
    public static String reverseWords(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) return sentence;
        String[] words = sentence.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i > 0) sb.append(" ");
        }
        return sb.toString();
    }

    /**
     * Checks whether a number is prime.
     */
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    /**
     * Counts how many times a character appears in a string (case-sensitive).
     */
    public static int countChar(String s, char c) {
        if (s == null) return 0;
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == c) count++;
        }
        return count;
    }

    /**
     * Calculates the average of a list of doubles.
     * @throws IllegalArgumentException if list is null or empty
     */
    public static double average(List<Double> numbers) {
        if (numbers == null || numbers.isEmpty())
            throw new IllegalArgumentException("List must not be null or empty");
        double sum = 0;
        for (double d : numbers) sum += d;
        return sum / numbers.size();
    }
}
