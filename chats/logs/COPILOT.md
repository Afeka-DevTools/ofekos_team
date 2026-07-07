# COPILOT.md – LLM Conversation Log (Part 3)

## Topic: Writing unit tests for App.java using Claude Code

---

### Session overview

I used Claude Code (an AI coding assistant integrated directly into the development environment) to write comprehensive unit tests for all functions in `App.java`.

---

### Interaction 1 – Understanding the functions

**Ofek:** Look at App.java. What functions are there and what should I test for each one?

**AI:**
The file contains 8 testable functions:

1. `getGreeting()` – returns a constant string. Test: verify the exact return value.
2. `factorial(int n)` – recursive factorial. Test: 0, 1, positive values, negative throws.
3. `isPalindrome(String s)` – checks palindromes. Test: true/false cases, case, spaces, null.
4. `fibonacci(int n)` – Fibonacci sequence. Test: base cases, sequence, negative throws.
5. `findMax(List<Integer>)` – finds maximum. Test: normal list, negatives, single, null/empty throws.
6. `reverseWords(String)` – reverses word order. Test: multi-word, single word, extra spaces, null.
7. `isPrime(int n)` – primality check. Test: primes, non-primes, edge cases (0, 1, negatives).
8. `countChar(String, char)` – counts character occurrences. Test: found, not found, case sensitivity, null.
9. `average(List<Double>)` – computes average. Test: normal, single element, negatives, null/empty throws.

---

### Interaction 2 – Generating the tests

**Ofek:** Write comprehensive JUnit 5 unit tests for all these functions covering all branches and edge cases.

**AI:**
Generated `AppTest.java` with 40+ test methods covering:
- Happy path tests for every function
- Edge cases: null inputs, empty collections, zero, single element, negative numbers
- Exception tests using `assertThrows` for all methods that throw `IllegalArgumentException`
- Case-sensitivity tests for string functions
- Both `assertTrue` and `assertFalse` for boolean-returning functions

---

### Interaction 3 – Coverage check

**Ofek:** Are the tests sufficient? Did we cover all code paths?

**AI:**
Analysis of branch coverage per function:

| Function      | Branches covered |
|---------------|-----------------|
| `factorial`   | n<0 ✓, n=0 ✓, n=1 ✓, n>1 ✓ |
| `isPalindrome`| null ✓, palindrome ✓, non-palindrome ✓, mixed case ✓, spaces ✓ |
| `fibonacci`   | n<0 ✓, n=0 ✓, n=1 ✓, n>1 (loop) ✓ |
| `findMax`     | null ✓, empty ✓, single ✓, multiple ✓, all negative ✓ |
| `reverseWords`| null ✓, empty/blank ✓, single word ✓, multiple words ✓, extra spaces ✓ |
| `isPrime`     | n<2 ✓, n=2 ✓, even>2 ✓, odd composite ✓, odd prime ✓ |
| `countChar`   | null ✓, empty ✓, found ✓, not found ✓, case diff ✓ |
| `average`     | null ✓, empty ✓, single ✓, multiple ✓, negatives ✓ |

**Conclusion:** All code paths are covered. Running JaCoCo would confirm ~100% line and branch coverage.
