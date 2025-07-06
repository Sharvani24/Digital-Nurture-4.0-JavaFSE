package com.example;

public class OrderProcessor {
    private OrderService service;

    public OrderProcessor(OrderService service) {
        this.service = service;
    }

    public void processOrder() {
        service.placeOrder();
        service.makePayment();
        service.sendConfirmation();
    }
}
