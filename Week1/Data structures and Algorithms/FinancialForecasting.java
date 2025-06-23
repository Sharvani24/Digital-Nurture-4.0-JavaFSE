//Exercise 7: Financial Forecasting
/* 1. Understand Recursive Algorithms
Recursion is when a method calls itself to solve a problem. It breaks a problem into smaller sub-problems.
Example: Factorial(n) = n × Factorial(n−1)

Recursion is useful when a problem has a repetitive pattern or substructure.
In financial forecasting, we can use recursion to model: Future Value = Current Value × (1 + Growth Rate)^Years*/

/* 2. Setup
We’ll create a method calculateFutureValueRecursive(double currentValue, double growthRate, int years).*/

//3.Implementation (Recursive + Optimized)
public class FinancialForecasting {

    // Recursive method to calculate future value
    public static double calculateFutureValueRecursive(double currentValue, double growthRate, int years) {
        if (years == 0) {
            return currentValue;
        }
        return (1 + growthRate) * calculateFutureValueRecursive(currentValue, growthRate, years - 1);
    }

    // Optimized recursive method with memoization (optional for large 'years')
    public static double calculateFutureValueMemo(double currentValue, double growthRate, int years, Double[] memo) {
        if (years == 0) return currentValue;
        if (memo[years] != null) return memo[years];
        memo[years] = (1 + growthRate) * calculateFutureValueMemo(currentValue, growthRate, years - 1, memo);
        return memo[years];
    }

    public static void main(String[] args) {
        double currentValue = 10000;   // Initial investment
        double growthRate = 0.05;      // 5% growth per year
        int years = 5;

        System.out.println("=== Recursive Forecast ===");
        double futureValue1 = calculateFutureValueRecursive(currentValue, growthRate, years);
        System.out.printf("Future value after %d years: %.2f\n", years, futureValue1);

        System.out.println("\n=== Optimized Recursive Forecast (Memoization) ===");
        Double[] memo = new Double[years + 1];
        double futureValue2 = calculateFutureValueMemo(currentValue, growthRate, years, memo);
        System.out.printf("Future value after %d years: %.2f\n", years, futureValue2);
    }
}
/* 4. Analysis
🔹 Time Complexity
Simple Recursion: O(n) – one recursive call per year.
Memoized Recursion: O(n) – avoids recomputation by storing results.
🔹 Optimization Techniques
Memoization: Store results in a cache (Double[] memo) to avoid recomputing previous years.
Iterative Approach (not shown): Uses a loop, usually more efficient in Java due to no stack overhead.
*/