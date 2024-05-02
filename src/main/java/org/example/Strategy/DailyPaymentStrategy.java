package org.example.Strategy;

import org.example.Model.Ticket;

import java.time.temporal.ChronoUnit;

public class DailyPaymentStrategy extends PaymentStrategy{
    public DailyPaymentStrategy(){
        this.setBikeCharges(100);
        this.setCarCharges(200);
        this.setTruckCharges(300);
    }

    public double calculateCost(Ticket ticket){
        long days = ChronoUnit.DAYS.between(ticket.getEntryTime(),ticket.getExitTime());
        return getChargeType(ticket) * days;
    }
}
