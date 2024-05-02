package org.example.Model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class Ticket {
    private String ticketId;
    private Vehicle vehicle;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private Slot slot;
    private double charges;
    private boolean isActive;

    Ticket(Vehicle vehicle,Slot slot){
        this.ticketId = UUID.randomUUID().toString();
        this.entryTime = LocalDateTime.now();
        this.vehicle = vehicle;
        this.slot = slot;
        this.isActive = true;
    }


}
