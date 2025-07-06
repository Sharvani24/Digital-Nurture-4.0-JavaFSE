
package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class MessageSenderTest {

    @Test
    public void testSendMessageWithArguments() {
        NotificationService mockService = mock(NotificationService.class);
        MessageSender sender = new MessageSender(mockService);

        sender.sendMessage("john@example.com", "Hello John");

        // Verify method was called with specific arguments
        verify(mockService).send(eq("john@example.com"), eq("Hello John"));
    }
}
