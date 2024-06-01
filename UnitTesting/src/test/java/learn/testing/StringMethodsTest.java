package learn.testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringMethodsTest {

    @Test
    void countDigits() {
        int expected = 0;
        int actual = StringMethods.countDigits(null);
        // A null string should return 0 counted digits.
        assertEquals(expected, actual, "Here is the message we want to return!");
    }
}