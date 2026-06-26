package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    // ─────────────────────────────────────────────
    // getGreeting
    // ─────────────────────────────────────────────

    @Test
    @DisplayName("getGreeting returns 'Hello World!'")
    void testGetGreeting() {
        assertEquals("Hello World!", App.getGreeting());
    }

    // ─────────────────────────────────────────────
    // factorial
    // ─────────────────────────────────────────────

    @Test
    @DisplayName("factorial(0) = 1")
    void testFactorialZero() {
        assertEquals(1, App.factorial(0));
    }

    @Test
    @DisplayName("factorial(1) = 1")
    void testFactorialOne() {
        assertEquals(1, App.factorial(1));
    }

    @Test
    @DisplayName("factorial of positive number")
    void testFactorialPositive() {
        assertEquals(120, App.factorial(5));
        assertEquals(720, App.factorial(6));
    }

    @Test
    @DisplayName("factorial throws on negative input")
    void testFactorialNegative() {
        assertThrows(IllegalArgumentException.class, () -> App.factorial(-1));
    }

    // ─────────────────────────────────────────────
    // isPalindrome
    // ─────────────────────────────────────────────

    @Test
    @DisplayName("simple palindrome")
    void testIsPalindromeTrue() {
        assertTrue(App.isPalindrome("racecar"));
        assertTrue(App.isPalindrome("madam"));
    }

    @Test
    @DisplayName("palindrome is case-insensitive")
    void testIsPalindromeCaseInsensitive() {
        assertTrue(App.isPalindrome("RaceCar"));
    }

    @Test
    @DisplayName("palindrome ignores spaces")
    void testIsPalindromeWithSpaces() {
        assertTrue(App.isPalindrome("never odd or even"));
    }

    @Test
    @DisplayName("non-palindrome returns false")
    void testIsPalindromeFalse() {
        assertFalse(App.isPalindrome("hello"));
    }

    @Test
    @DisplayName("null returns false for isPalindrome")
    void testIsPalindromeNull() {
        assertFalse(App.isPalindrome(null));
    }

    @Test
    @DisplayName("single character is palindrome")
    void testIsPalindromeSingleChar() {
        assertTrue(App.isPalindrome("a"));
    }

    // ─────────────────────────────────────────────
    // fibonacci
    // ─────────────────────────────────────────────

    @Test
    @DisplayName("fibonacci(0) = 0")
    void testFibonacciZero() {
        assertEquals(0, App.fibonacci(0));
    }

    @Test
    @DisplayName("fibonacci(1) = 1")
    void testFibonacciOne() {
        assertEquals(1, App.fibonacci(1));
    }

    @Test
    @DisplayName("fibonacci sequence values")
    void testFibonacciSequence() {
        assertEquals(1,  App.fibonacci(2));
        assertEquals(2,  App.fibonacci(3));
        assertEquals(5,  App.fibonacci(5));
        assertEquals(55, App.fibonacci(10));
    }

    @Test
    @DisplayName("fibonacci throws on negative input")
    void testFibonacciNegative() {
        assertThrows(IllegalArgumentException.class, () -> App.fibonacci(-1));
    }

    // ─────────────────────────────────────────────
    // findMax
    // ─────────────────────────────────────────────

    @Test
    @DisplayName("findMax returns maximum value")
    void testFindMaxBasic() {
        assertEquals(9, App.findMax(Arrays.asList(3, 9, 1, 7)));
    }

    @Test
    @DisplayName("findMax with single element")
    void testFindMaxSingleElement() {
        assertEquals(42, App.findMax(Collections.singletonList(42)));
    }

    @Test
    @DisplayName("findMax with all equal values")
    void testFindMaxAllEqual() {
        assertEquals(5, App.findMax(Arrays.asList(5, 5, 5)));
    }

    @Test
    @DisplayName("findMax with negative numbers")
    void testFindMaxNegatives() {
        assertEquals(-1, App.findMax(Arrays.asList(-10, -3, -1, -7)));
    }

    @Test
    @DisplayName("findMax throws on null list")
    void testFindMaxNullList() {
        assertThrows(IllegalArgumentException.class, () -> App.findMax(null));
    }

    @Test
    @DisplayName("findMax throws on empty list")
    void testFindMaxEmptyList() {
        assertThrows(IllegalArgumentException.class, () -> App.findMax(Collections.emptyList()));
    }

    // ─────────────────────────────────────────────
    // reverseWords
    // ─────────────────────────────────────────────

    @Test
    @DisplayName("reverseWords reverses two words")
    void testReverseWordsBasic() {
        assertEquals("World Hello", App.reverseWords("Hello World"));
    }

    @Test
    @DisplayName("reverseWords reverses multiple words")
    void testReverseWordsMultiple() {
        assertEquals("Java in tests unit", App.reverseWords("unit tests in Java"));
    }

    @Test
    @DisplayName("reverseWords with single word")
    void testReverseWordsSingleWord() {
        assertEquals("Hello", App.reverseWords("Hello"));
    }

    @Test
    @DisplayName("reverseWords with extra spaces")
    void testReverseWordsExtraSpaces() {
        assertEquals("World Hello", App.reverseWords("  Hello   World  "));
    }

    @Test
    @DisplayName("reverseWords with null returns null")
    void testReverseWordsNull() {
        assertNull(App.reverseWords(null));
    }

    // ─────────────────────────────────────────────
    // isPrime
    // ─────────────────────────────────────────────

    @Test
    @DisplayName("known prime numbers")
    void testIsPrimeTrue() {
        assertTrue(App.isPrime(2));
        assertTrue(App.isPrime(3));
        assertTrue(App.isPrime(7));
        assertTrue(App.isPrime(13));
        assertTrue(App.isPrime(97));
    }

    @Test
    @DisplayName("non-prime numbers")
    void testIsPrimeFalse() {
        assertFalse(App.isPrime(1));
        assertFalse(App.isPrime(4));
        assertFalse(App.isPrime(9));
        assertFalse(App.isPrime(100));
    }

    @Test
    @DisplayName("isPrime with negative and zero")
    void testIsPrimeNonPositive() {
        assertFalse(App.isPrime(0));
        assertFalse(App.isPrime(-5));
    }

    // ─────────────────────────────────────────────
    // countChar
    // ─────────────────────────────────────────────

    @Test
    @DisplayName("countChar counts occurrences correctly")
    void testCountCharBasic() {
        assertEquals(3, App.countChar("banana", 'a'));
    }

    @Test
    @DisplayName("countChar returns 0 when char not found")
    void testCountCharNotFound() {
        assertEquals(0, App.countChar("hello", 'z'));
    }

    @Test
    @DisplayName("countChar is case-sensitive")
    void testCountCharCaseSensitive() {
        assertEquals(1, App.countChar("Hello", 'H'));
        assertEquals(0, App.countChar("Hello", 'h'));
    }

    @Test
    @DisplayName("countChar with null string returns 0")
    void testCountCharNull() {
        assertEquals(0, App.countChar(null, 'a'));
    }

    @Test
    @DisplayName("countChar on empty string returns 0")
    void testCountCharEmptyString() {
        assertEquals(0, App.countChar("", 'a'));
    }

    // ─────────────────────────────────────────────
    // average
    // ─────────────────────────────────────────────

    @Test
    @DisplayName("average of a list of doubles")
    void testAverageBasic() {
        assertEquals(3.0, App.average(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0)), 0.0001);
    }

    @Test
    @DisplayName("average of single element")
    void testAverageSingleElement() {
        assertEquals(7.5, App.average(Collections.singletonList(7.5)), 0.0001);
    }

    @Test
    @DisplayName("average of negative numbers")
    void testAverageNegatives() {
        assertEquals(-2.0, App.average(Arrays.asList(-1.0, -2.0, -3.0)), 0.0001);
    }

    @Test
    @DisplayName("average throws on null list")
    void testAverageNullList() {
        assertThrows(IllegalArgumentException.class, () -> App.average(null));
    }

    @Test
    @DisplayName("average throws on empty list")
    void testAverageEmptyList() {
        assertThrows(IllegalArgumentException.class, () -> App.average(Collections.emptyList()));
    }
}
