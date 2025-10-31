package com.solvd.taxi.model;

import java.time.LocalDateTime;

public class Payment {
    private int paymentId;
    private double amount;
    private LocalDateTime paymentDate;
    private int methodId;

    public Payment(int paymentId, double amount, LocalDateTime paymentDate, int methodId) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.methodId = methodId;
    }

    public int getPaymentId() { return paymentId; }
    public double getAmount() { return amount; }
    public LocalDateTime getPaymentDate() { return paymentDate; }
    public int getMethodId() { return methodId; }

    @Override
    public String toString() {
        return "Payment {id=" + paymentId + ", amount=" + amount + ", date=" + paymentDate + ", methodId=" + methodId + "}";
    }
}
