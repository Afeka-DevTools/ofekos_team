# Chat Log – Learning Unit Testing in Java

**Tool used:** Claude (claude.ai)
**Topic:** Understanding unit testing in Java with JUnit 5

---

**Ofek:** מה זה בדיקות יחידה (Unit Testing) ולמה חשוב לכתוב אותן?

**Claude:** בדיקות יחידה הן בדיקות שבודקות יחידה אחת קטנה של קוד – בדרך כלל מתודה אחת – בבידוד מהשאר. המטרה היא לוודא שכל פונקציה מתנהגת כמצופה עבור כל קלט אפשרי.

**למה חשוב:**
- מוצאים באגים מוקדם, לפני שהקוד מגיע לפרודקשן
- מקלים על refactoring – אפשר לשנות קוד ולדעת מיד אם שברת משהו
- הבדיקות משמשות כתיעוד חי של ההתנהגות הצפויה

---

**Ofek:** איך כותבים בדיקות יחידה בJava? אילו כלים משתמשים?

**Claude:** בJava הכלי הנפוץ ביותר הוא **JUnit 5**. בדיקה בסיסית נראית כך:

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MyTest {

    @Test
    void addition_returnsCorrectSum() {
        assertEquals(4, 2 + 2);
    }
}
```

**Annotations עיקריות:**

| Annotation | תפקיד |
|------------|-------|
| `@Test` | מסמן מתודה כבדיקה |
| `@DisplayName` | שם קריא לבדיקה |
| `@BeforeEach` | רץ לפני כל בדיקה |
| `@AfterEach` | רץ אחרי כל בדיקה |

---

**Ofek:** אילו פונקציות Assert קיימות ומתי משתמשים בכל אחת?

**Claude:** אלו ה-Assert methods העיקריות ב-JUnit 5:

| Method | מתי משתמשים |
|--------|------------|
| `assertEquals(expected, actual)` | כשרוצים לוודא שערך שווה לצפוי |
| `assertNotEquals(a, b)` | כשרוצים לוודא שהערכים שונים |
| `assertTrue(condition)` | כשהפונקציה אמורה להחזיר `true` |
| `assertFalse(condition)` | כשהפונקציה אמורה להחזיר `false` |
| `assertNull(obj)` | כשמצפים לקבל `null` |
| `assertNotNull(obj)` | כשמצפים שהתוצאה לא תהיה `null` |
| `assertThrows(Exception.class, () -> ...)` | כשמצפים שתיזרק חריגה |

---

**Ofek:** איך יודעים שהבדיקות מספיקות? מה זה code coverage?

**Claude:** **Code Coverage** מודד כמה אחוז מהקוד שלך רץ בזמן הבדיקות.

**סוגי כיסוי:**

| סוג | הסבר |
|-----|------|
| Line Coverage | כמה שורות קוד רצו |
| Branch Coverage | כמה ענפים של `if/else` נבדקו |
| Method Coverage | כמה מתודות נקראו |

הכלי הנפוץ בJava/Gradle הוא **JaCoCo**. מוסיפים ל-`build.gradle`:

```groovy
plugins {
    id 'jacoco'
}
```

ומריצים:
```bash
./gradlew test jacocoTestReport
```

הדוח יוצא ב-`app/build/reports/jacoco/test/html/index.html` – ירוק = נבדק, אדום = לא נבדק.

---

**Ofek:** איך בודקים שכל נתיבי הפונקציה נבדקו? תן דוגמה עם factorial.

**Claude:** לכל פונקציה צריך לזהות את כל ה"נתיבים" האפשריים דרך הקוד:

```java
public static long factorial(int n) {
    if (n < 0) throw new IllegalArgumentException(...); // נתיב 1
    if (n == 0 || n == 1) return 1;                     // נתיב 2
    return n * factorial(n - 1);                        // נתיב 3
}
```

לכן יש לכתוב בדיקה לכל נתיב:

```java
@Test void factorial_negative_throws() {
    assertThrows(IllegalArgumentException.class, () -> App.factorial(-1));
}

@Test void factorial_zero_returnsOne() {
    assertEquals(1, App.factorial(0));
}

@Test void factorial_one_returnsOne() {
    assertEquals(1, App.factorial(1));
}

@Test void factorial_positive_returnsCorrectResult() {
    assertEquals(120, App.factorial(5));
}
```

**כלל אצבע:** מספר הבדיקות המינימלי לפונקציה = מספר ה-`if` בה + 1.
