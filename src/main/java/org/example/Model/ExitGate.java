package org.example.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.Enums.PaymentType;
import org.example.Strategy.PaymentStrategy;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class ExitGate {
    private int id;

    public Payment processPayment(PaymentType paymentType, Ticket ticket, PaymentStrategy paymentStrategy) {
        ticket.setExitTime(LocalDateTime.now());
        double cost = paymentStrategy.calculateCost(ticket);
        ticket.setCharges(cost);
        Payment p = new Payment(cost,ticket,paymentStrategy);
        p.makePayment(paymentType);

        freeParkingSpot(ticket.getSlot());
        ticket.setActive(false);
        return p;
    }

    private void freeParkingSpot(Slot slot) {
        slot.setOccupied(false);
    }
}
