package org.example.Model;

import lombok.Data;

@Data
public class EntryGate {
    private int id;

    public EntryGate(int id) {
        this.id = id;
    }

    public Ticket generateTicket(Vehicle vehicle) {
        if(!ParkingLot.INSTANCE.isParkingSlotAvailable(vehicle.getVehicleType())) {
            System.out.println("Parking is full");
            return null;
        }

        Slot slot = ParkingLot.INSTANCE.getParkingSlot(vehicle.getVehicleType());
        return new Ticket(vehicle, slot);
    }
}
