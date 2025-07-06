package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class OrderProcessorTest {

    @Test
    public void testMethodCallOrder() {
        OrderService mockService = mock(OrderService.class);
        OrderProcessor processor = new OrderProcessor(mockService);

        processor.processOrder();

        // Verify methods were called in the correct order
        InOrder inOrder = inOrder(mockService);
        inOrder.verify(mockService).placeOrder();
        inOrder.verify(mockService).makePayment();
        inOrder.verify(mockService).sendConfirmation();
    }
}
