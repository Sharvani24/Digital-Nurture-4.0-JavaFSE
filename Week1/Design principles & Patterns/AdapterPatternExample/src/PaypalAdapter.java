public class PaypalAdapter implements PaymentProcessor {
    private PaypalGateway paypal;

    public PaypalAdapter(PaypalGateway paypal) {
        this.paypal = paypal;
    }

    @Override
    public void processPayment(double amount) {
        paypal.makePaypalPayment(amount);
    }
}
