package org.example.Model;

import lombok.Data;
import org.example.Enums.VehicleType;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class ParkingLot {
    private String id;
    private List<Floor> floorList;
    private List<EntryGate> entryGates;
    private List<ExitGate> exitGates;
    private Address address;
    private ParkingStrategy parkingStrategy;

    public static ParkingLot INSTANCE = new ParkingLot();

    ParkingLot(){
        id = UUID.randomUUID().toString();
        floorList = new ArrayList<>();
        entryGates = new ArrayList<>();
        exitGates = new ArrayList<>();
    }

    public boolean isParkingSlotAvailable(VehicleType vehicleType) {
        for(Floor floor : floorList) {
            if(floor.isParkingSlotAvailable(vehicleType)) {
                return true;
            }
        }
        return false;
    }

    public Slot getParkingSlot(VehicleType vehicleType) {
        for(Floor floor : floorList) {
            return floor.getSlot(vehicleType);
        }
        return null;
    }

}
