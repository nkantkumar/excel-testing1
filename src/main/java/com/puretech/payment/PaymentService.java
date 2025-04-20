package com.puretech.payment;

class PaymentService {
    private final PaymentGateway gateway;
    public PaymentService(PaymentGateway gateway) { this.gateway = gateway; }
    public boolean pay(double amount) {
        return gateway.charge(amount);
    }
}