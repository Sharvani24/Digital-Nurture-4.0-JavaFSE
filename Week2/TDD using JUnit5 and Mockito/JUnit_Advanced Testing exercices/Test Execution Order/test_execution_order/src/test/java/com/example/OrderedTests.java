package com.example;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(OrderAnnotation.class)
public class OrderedTests {

    @Test
    @Order(1)
    public void testFirst() {
        System.out.println("Running testFirst");
        assertTrue(true);
    }

    @Test
    @Order(3)
    public void testThird() {
        System.out.println("Running testThird");
        assertTrue(true);
    }

    @Test
    @Order(2)
    public void testSecond() {
        System.out.println("Running testSecond");
        assertTrue(true);
    }
}
