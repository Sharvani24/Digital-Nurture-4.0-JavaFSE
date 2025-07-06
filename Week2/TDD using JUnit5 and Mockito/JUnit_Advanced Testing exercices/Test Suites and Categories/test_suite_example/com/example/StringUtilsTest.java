
package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringUtilsTest {

    @Test
    public void testToUpperCase() {
        assertEquals("HELLO", "hello".toUpperCase());
    }

    @Test
    public void testLength() {
        assertEquals(5, "hello".length());
    }
}
