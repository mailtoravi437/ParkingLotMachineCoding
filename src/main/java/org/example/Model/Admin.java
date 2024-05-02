package org.example.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
public class Admin {
    private final String id;
    private LoginInfo loginInfo;
    private ContactInfo contactInfo;

    public Admin() {
        this.id = UUID.randomUUID().toString();
    }

    ParkingLot parkingLot = ParkingLot.INSTANCE;

    public void addFloor(Floor floor) {
        parkingLot.getFloorList().add(floor);
    }

    public void addSlot(Floor f, Slot s) {
       f.addSlot(s);
    }

    public void addEntranceGate(EntryGate g) {
        parkingLot.getEntryGates().add(g);
    }


    public void addExitGate(ExitGate g) {
        parkingLot.getExitGates().add(g);
    }

    public void setParkingStrategy(ParkingStrategy parkingStrategy){
        parkingLot.setParkingStrategy(parkingStrategy);
    }
}
