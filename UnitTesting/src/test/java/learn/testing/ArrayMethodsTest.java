package learn.testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayMethodsTest {

    @Test
    void shiftLeftShouldReturnNullWhenNull() {
        int[] actual = ArrayMethods.shiftLeft(null);
        assertNull(actual);
    }

    @Test
    void shiftLeftShouldDoSomethingElse() {

    }
}