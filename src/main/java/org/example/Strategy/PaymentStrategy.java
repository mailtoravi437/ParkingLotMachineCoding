package org.example.Strategy;

import lombok.Data;
import org.example.Model.Ticket;

@Data
public abstract class PaymentStrategy {
    private double bikeCharges;
    private double carCharges;
    private double truckCharges;

    public abstract double calculateCost(Ticket ticket);

    public double getChargeType(Ticket ticket) {
        switch (ticket.getVehicle().getVehicleType()) {
            case BIKE:
                return bikeCharges;
            case CAR:
                return carCharges;
            case TRUCK:
                return truckCharges;
            default:
                return 0;
        }
    }
}
