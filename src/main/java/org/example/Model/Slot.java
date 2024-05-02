package org.example.Model;

import lombok.Getter;
import lombok.Setter;
import org.example.Enums.SlotType;

@Getter
@Setter
public abstract class Slot {
    private String slotId;
    private SlotType slotType;
    private boolean isOccupied;
    private Vehicle vehicle;

    Slot(String slotId, SlotType slotType){
        this.slotId = slotId;
        this.slotType = slotType;
        this.isOccupied = false;
        this.vehicle = null;
    }

    public void parkVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
        this.isOccupied = true;
    }

    public void removeVehicle(){
        this.vehicle = null;
        this.isOccupied = false;
    }

}
