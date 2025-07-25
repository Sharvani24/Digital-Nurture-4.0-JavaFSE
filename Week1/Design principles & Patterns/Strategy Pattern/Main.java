public class Main {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        // Use Credit Card
        context.setPaymentStrategy(new CreditCardPayment("1234-5678-9876-5432"));
        context.payAmount(250.0);

        // Use PayPal
        context.setPaymentStrategy(new PayPalPayment("user@example.com"));
        context.payAmount(120.5);
    }
}
