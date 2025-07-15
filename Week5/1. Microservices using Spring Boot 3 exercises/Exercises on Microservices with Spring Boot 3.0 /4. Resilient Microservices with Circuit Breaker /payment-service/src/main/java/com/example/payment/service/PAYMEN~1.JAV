package com.example.payment.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PaymentService {

    private static final Logger logger = LoggerFactory.getLogger(PaymentService.class);
    private final RestTemplate restTemplate = new RestTemplate();
    private static final String PAYMENT_SERVICE = "paymentService";

    @CircuitBreaker(name = PAYMENT_SERVICE, fallbackMethod = "fallbackResponse")
    public String callThirdPartyApi() {
        logger.info("Calling third-party API...");
        String response = restTemplate.getForObject("https://httpstat.us/200?sleep=5000", String.class);
        return "Response from 3rd party: " + response;
    }

    public String fallbackResponse(Throwable throwable) {
        logger.error("Fallback triggered: {}", throwable.toString());
        return "Fallback: Payment service is currently unavailable. Please try again later.";
    }
}
