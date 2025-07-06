
package com.example;

public class PerformanceTester {
    public void performTask() {
        try {
            // Simulate a time-consuming task
            Thread.sleep(2000); // sleeps for 2 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
