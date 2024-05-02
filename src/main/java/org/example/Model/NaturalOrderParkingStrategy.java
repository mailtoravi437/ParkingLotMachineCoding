package org.example.Model;

import java.util.List;

public class NaturalOrderParkingStrategy extends ParkingStrategy {
    @Override
    public void park(Vehicle vehicle) {
        System.out.println("Parked vehicle in natural order");
    }

    @Override
    public Slot park(List<Slot> slots) {
        return slots.getFirst();
    }
}
