# LEARNING.md – LLM Conversation Log (Part 2)

## Topic: Unit Testing in Java


---

### Prompt 1

**Team:** I'm a student learning Java. Can you explain what unit testing is and how to write unit tests in Java using JUnit 5? Please include examples and explain the most important Assert methods.

**AI:**
Unit testing means testing a single "unit" of code (usually a method) in isolation, to verify it behaves correctly for a variety of inputs.

In Java, the most popular framework is **JUnit 5** (Jupiter). A test class looks like this:

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MyTest {

    @Test
    void additionWorks() {
        assertEquals(4, 2 + 2);
    }
}
```

**Key annotations:**
- `@Test` – marks a method as a test
- `@DisplayName("...")` – gives a human-readable name to the test
- `@BeforeEach` / `@AfterEach` – setup/teardown before or after every test

**Key Assert methods:**

| Method | Purpose |
|--------|---------|
| `assertEquals(expected, actual)` | Checks two values are equal |
| `assertNotEquals(a, b)` | Checks two values are NOT equal |
| `assertTrue(condition)` | Checks condition is true |
| `assertFalse(condition)` | Checks condition is false |
| `assertNull(obj)` | Checks object is null |
| `assertNotNull(obj)` | Checks object is not null |
| `assertThrows(ExceptionClass, () -> ...)` | Checks that a lambda throws the expected exception |

---

### Prompt 2

**Team:** How do I know if my tests are sufficient? What is code coverage and how do I check that all code paths are tested?

**AI:**
**Code coverage** measures what percentage of your source code is executed when your tests run. The most important metric is **branch coverage** – making sure every `if/else`, `switch`, and loop condition has been tested for both the true and false path.

**How to check coverage in Gradle / JUnit 5:**

Add the JaCoCo plugin to `build.gradle`:
```groovy
plugins {
    id 'jacoco'
}

jacocoTestReport {
    reports {
        html.required = true
    }
}
```

Then run:
```bash
./gradlew test jacocoTestReport
```

Open `app/build/reports/jacoco/test/html/index.html` to see a coloured report showing which lines were covered (green) and which were not (red).

**Rules of thumb for good tests:**
1. Test the "happy path" (normal expected input)
2. Test edge cases (0, empty string, null, single element, very large numbers)
3. Test error paths – what happens with invalid input? Does it throw the right exception?
4. Test every branch of every `if` statement

---

### Prompt 3

**Team:** What is the difference between assertEquals and assertSame? When should I use assertThrows?

**AI:**
- `assertEquals` compares **values** (uses `.equals()`).
- `assertSame` compares **references** (uses `==`). Use it only when you need to verify both variables point to the exact same object in memory. This is rarely needed.

`assertThrows` is used when you **expect** the method to throw an exception. Example:

```java
@Test
void factorial_negative_throws() {
    assertThrows(IllegalArgumentException.class, () -> App.factorial(-1));
}
```

This test **passes** if `factorial(-1)` throws `IllegalArgumentException`, and **fails** if it does not throw (or throws a different exception).
