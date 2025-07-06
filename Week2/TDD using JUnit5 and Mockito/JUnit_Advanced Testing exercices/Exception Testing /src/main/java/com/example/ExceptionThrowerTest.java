package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExceptionThrowerTest {

    @Test
    public void testThrowException() {
        ExceptionThrower thrower = new ExceptionThrower();
        IllegalArgumentException thrown = assertThrows(
            IllegalArgumentException.class,
            () -> thrower.throwException(true)
        );
        assertEquals("Expected exception was thrown.", thrown.getMessage());
    }

    @Test
    public void testNoException() {
        ExceptionThrower thrower = new ExceptionThrower();
        assertDoesNotThrow(() -> thrower.throwException(false));
    }
}
