//Design principles & Patterns
//Exercise 2: Implementing the Factory Method Pattern

// File Name: Main.java

interface Notification {
    void notifyUser();
}

class EmailNotification implements Notification {
    public void notifyUser() {
        System.out.println("Sending an Email Notification");
    }
}

class SMSNotification implements Notification {
    public void notifyUser() {
        System.out.println("Sending an SMS Notification");
    }
}

class PushNotification implements Notification {
    public void notifyUser() {
        System.out.println("Sending a Push Notification");
    }
}

abstract class NotificationFactory {
    public abstract Notification createNotification();  // Factory Method
}

class EmailNotificationFactory extends NotificationFactory {
    public Notification createNotification() {
        return new EmailNotification();
    }
}

class SMSNotificationFactory extends NotificationFactory {
    public Notification createNotification() {
        return new SMSNotification();
    }
}

class PushNotificationFactory extends NotificationFactory {
    public Notification createNotification() {
        return new PushNotification();
    }
}

public class factoryMethodPattern {
    public static void main(String[] args) {
        NotificationFactory factory;

        // Email Notification
        factory = new EmailNotificationFactory();
        Notification email = factory.createNotification();
        email.notifyUser();  

        // SMS Notification
        factory = new SMSNotificationFactory();
        Notification sms = factory.createNotification();
        sms.notifyUser();  

        // Push Notification
        factory = new PushNotificationFactory();
        Notification push = factory.createNotification();
        push.notifyUser();  
    }
}
