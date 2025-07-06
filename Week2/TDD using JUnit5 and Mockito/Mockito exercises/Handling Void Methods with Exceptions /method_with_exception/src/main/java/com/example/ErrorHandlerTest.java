package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ErrorHandlerTest {

    @Test
    public void testVoidMethodThrowsException() {
        ExceptionLogger mockLogger = mock(ExceptionLogger.class);

        // Stub the void method to throw an exception
        doThrow(new RuntimeException("Log failed")).when(mockLogger).logError("Critical Error");

        ErrorHandler handler = new ErrorHandler(mockLogger);

        // Assert that exception is thrown
        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            handler.handleError("Critical Error");
        });

        assertEquals("Log failed", thrown.getMessage());

        // Verify interaction
        verify(mockLogger).logError("Critical Error");
    }
}
