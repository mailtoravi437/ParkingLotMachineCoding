package org.example.Strategy;

import org.example.Model.Ticket;

import java.time.temporal.ChronoUnit;

public class HourlyPaymentStrategy extends PaymentStrategy{
   public HourlyPaymentStrategy() {
       this.setBikeCharges(10);
       this.setCarCharges(20);
       this.setTruckCharges(30);
   }

    @Override
    public double calculateCost(Ticket ticket) {
        long hours = ChronoUnit.HOURS.between(ticket.getEntryTime(), ticket.getExitTime());
        return getChargeType(ticket) * hours;
    }
}
