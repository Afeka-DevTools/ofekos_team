# HW2 – Unit Testing with Gradle & Java

**Course:** Development Tools | **Semester:** 2026B
**Lecturers:** Tom Cohen, Lior Rotberg

---

## Team Members

| # | Name | 
|---|------|
| 1 | Ofek Osher |
| 2 | Keren Vinogradov |
| 3 | Shira Tal | 

---

## Project Structure

| Path | Description |
|------|-------------|
| `app/src/main/java/com/example/App.java` | Functions under test |
| `app/src/test/java/com/example/AppTest.java` | Unit tests |
| `app/build.gradle` | Gradle build config |
| `settings.gradle` | Gradle settings |
| `chats/LEARNING.md` | LLM conversation log – part 2 (self-learning) |
| `chats/COPILOT.md` | LLM conversation log – part 3 (writing tests) |
| `logs/LEARNING.md` | Copy of the part 2 conversation log |
| `logs/COPILOT.md` | Copy of the part 3 conversation log |

---

## How to Run the Tests

### Prerequisites

| Requirement | Version |
|-------------|---------|
| Java | 17 or higher |
| Git | Any recent version |

### Steps

| Step | Action | Command |
|------|--------|---------|
| 1 | Clone the repository | `git clone https://github.com/Afeka-DevTools/ofekos_team.git` |
| 2 | Enter the project folder | `cd ofekos_team` |
| 3a | Run tests (Linux / macOS) | `./gradlew test` |
| 3b | Run tests (Windows) | `gradlew.bat test` |
| 4 | View HTML report | Open `app/build/reports/tests/test/index.html` in browser |

---

## Test Coverage Summary

| Function | Scenarios Tested | Edge Cases | Exception Tests |
|----------|-----------------|------------|-----------------|
| `getGreeting` | Returns correct string | — | — |
| `factorial` | 0, 1, positive values | — | Negative input → `IllegalArgumentException` |
| `isPalindrome` | True / false | null, single char, spaces, mixed case | — |
| `fibonacci` | 0, 1, sequence values | — | Negative input → `IllegalArgumentException` |
| `findMax` | Basic list, negatives, single element | null list, empty list | null/empty → `IllegalArgumentException` |
| `reverseWords` | Two words, multiple words | Single word, extra spaces, null | — |
| `isPrime` | Known primes, non-primes | 0, 1, negative numbers | — |
| `countChar` | Char found, not found | null string, empty string, case-sensitivity | — |
| `average` | Basic, negatives, single element | null list, empty list | null/empty → `IllegalArgumentException` |

---

## Assert Methods Used

| Method | Used for |
|--------|----------|
| `assertEquals` | Comparing expected vs actual values |
| `assertTrue` / `assertFalse` | Boolean-returning functions |
| `assertNull` / `assertNotNull` | Null checks |
| `assertThrows` | Verifying exceptions are thrown correctly |
