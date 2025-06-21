//Exercise 7: Financial Forecasting
import java.util.Arrays;

public class FinancialForecast {
    public static void main(String[] args) {
        //Monthly income data stored in an array
        double[] income = {12000.0, 13500.0, 12500.0, 14000.0, 15000.0, 14500.0};

        //Display original income data
        System.out.println("Monthly Income Data:");
        for (int i = 0; i < income.length; i++) {
            System.out.println("Month " + (i + 1) + ": $" + income[i]);
        }

        //Sort the income array
        Arrays.sort(income);

        //Calculate forecast as average of top 3 months
        int n = income.length;
        double forecast = (income[n - 1] + income[n - 2] + income[n - 3]) / 3;

        //Display sorted data and forecast
        System.out.println("\nSorted Income Data (Lowest to Highest):");
        for (double value : income) {
            System.out.println("$" + value);
        }

        System.out.println("\nForecasted Income for Next Month (average of top 3 months): $" + String.format("%.2f", forecast));
    }
}
