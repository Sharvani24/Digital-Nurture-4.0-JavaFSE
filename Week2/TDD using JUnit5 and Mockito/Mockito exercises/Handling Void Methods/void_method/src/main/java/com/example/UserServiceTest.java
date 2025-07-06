package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Test
    public void testRegisterUserLogsMessage() {
        Logger mockLogger = mock(Logger.class);

        // Stubbing void method (optional in this simple case)
        doNothing().when(mockLogger).log(anyString());

        UserService service = new UserService(mockLogger);
        service.registerUser("alice");

        // Verifying the log interaction
        verify(mockLogger).log(eq("User registered: alice"));
    }
}
