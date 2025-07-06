
package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.Duration;

public class PerformanceTesterTest {

    @Test
    public void testPerformTaskCompletesWithinTime() {
        PerformanceTester tester = new PerformanceTester();

        // Fail if performTask takes more than 3 seconds
        assertTimeout(Duration.ofSeconds(3), tester::performTask);
    }

    @Test
    public void testPerformTaskFailsIfTooSlow() {
        PerformanceTester tester = new PerformanceTester();

        // This will fail if performTask takes more than 1 second
        assertTimeout(Duration.ofSeconds(1), tester::performTask);
    }
}
