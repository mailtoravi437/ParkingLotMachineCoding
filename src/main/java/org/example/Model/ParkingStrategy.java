package org.example.Model;

import java.util.List;

public abstract class ParkingStrategy {
    public abstract void park(Vehicle vehicle);

    public abstract Slot park(List<Slot> slots);
}
