package org.example.Model;

import org.example.Enums.SlotType;
import org.example.Enums.VehicleType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Floor {
    private final String floorNumber;
    private Map<SlotType,List<Slot>> slotMap = new HashMap<>();

    public Floor(String floorNumber){
        this.floorNumber = floorNumber;
        slotMap.put(SlotType.CAR,new ArrayList<>());
        slotMap.put(SlotType.BIKE,new ArrayList<>());
        slotMap.put(SlotType.TRUCK,new ArrayList<>());
    }

    public void addSlot(Slot slot) {
        slotMap.get(slot.getSlotType()).add(slot);
    }
    public void removeSlot(Slot slot){
        slotMap.get(slot.getSlotType()).remove(slot);
    }

    public Slot getSlot(VehicleType vehicleType) {
       List<Slot> availableSpaces = new ArrayList<>();
       for(Slot p : slotMap.get(getSpaceType(vehicleType))) {
           if(!p.isOccupied()) {
               availableSpaces.add(p);
           }
       }
       return ParkingLot.INSTANCE.getParkingStrategy().park(availableSpaces);
    }

    private SlotType getSpaceType(VehicleType vehicleType) {
        return switch (vehicleType) {
            case CAR -> SlotType.CAR;
            case BIKE -> SlotType.BIKE;
            case TRUCK -> SlotType.TRUCK;
        };

    }

    public boolean isParkingSlotAvailable(VehicleType vehicleType) {
        for(Slot p : slotMap.get(getSpaceType(vehicleType))) {
            if(!p.isOccupied()) {
                return true;
            }
        }
        return false;
    }
}
