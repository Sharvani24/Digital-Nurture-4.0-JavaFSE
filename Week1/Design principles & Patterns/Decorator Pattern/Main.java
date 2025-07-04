public class Main {
    public static void main(String[] args) {
        Notifier notifier = new EmailNotifier();

        // Add SMS and Slack notifications
        notifier = new SMSNotifierDecorator(notifier);
        notifier = new SlackNotifierDecorator(notifier);

        notifier.send("System update scheduled at 10 PM tonight.");
    }
}
