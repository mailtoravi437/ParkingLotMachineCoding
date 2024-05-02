package org.example.Model;

import lombok.Data;
import org.example.Enums.PaymentType;
import org.example.Strategy.PaymentStrategy;

import java.time.LocalDateTime;
@Data
public class Payment {
    private String paymentId;
    private double amount;
    private LocalDateTime paymentTime;
    private  Ticket ticket;
    private PaymentType paymentType;
    private PaymentStrategy paymentStrategy;

    public Payment(double amount, Ticket ticket, PaymentStrategy paymentStrategy) {
        this.amount = amount;
        this.ticket = ticket;
        this.paymentStrategy = paymentStrategy;
    }

    public void makePayment(PaymentType paymentType) {
        System.out.println("Payment made successfully");
    }
}
