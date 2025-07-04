public class Main {
    public static void main(String[] args) {
        PaymentProcessor paypalProcessor = new PaypalAdapter(new PaypalGateway());
        paypalProcessor.processPayment(150.0);

        PaymentProcessor stripeProcessor = new StripeAdapter(new StripeGateway());
        stripeProcessor.processPayment(250.0);
    }
}
