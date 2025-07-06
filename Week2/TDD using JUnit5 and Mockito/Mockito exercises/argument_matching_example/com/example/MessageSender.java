
package com.example;

public class MessageSender {
    private NotificationService service;

    public MessageSender(NotificationService service) {
        this.service = service;
    }

    public void sendMessage(String user, String msg) {
        if (user != null && !user.isEmpty()) {
            service.send(user, msg);
        }
    }
}
