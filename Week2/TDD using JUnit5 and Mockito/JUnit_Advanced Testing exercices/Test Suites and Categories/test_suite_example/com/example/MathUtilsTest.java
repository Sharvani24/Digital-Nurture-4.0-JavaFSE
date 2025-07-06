
package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsTest {

    @Test
    public void testAddition() {
        assertEquals(5, 2 + 3);
    }

    @Test
    public void testSubtraction() {
        assertEquals(2, 5 - 3);
    }
}
