package org.example;

import org.example.Enums.PaymentType;
import org.example.Enums.SlotType;
import org.example.Enums.VehicleType;
import org.example.Model.*;
import org.example.Strategy.HourlyPaymentStrategy;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.INSTANCE;
        Address address = new Address();
        address.setAddressLine1("123 Main St");
        address.setCity("San Francisco");
        address.setState("CA");
        address.setCountry("USA");
        address.setZipCode("94105");

        parkingLot.setAddress(address);

        Admin admin = new Admin();
        Floor f1 = new Floor("1");
        Floor f2 = new Floor("2");
        Floor f3 = new Floor("3");

        admin.addFloor(f1);
        admin.addFloor(f2);
        admin.addFloor(f3);

        EntryGate gate1 = new EntryGate(1);
        ExitGate gate2 = new ExitGate(2);

        admin.addEntranceGate(gate1);
        admin.addExitGate(gate2);

        admin.setParkingStrategy(new NaturalOrderParkingStrategy());
        Slot bikeSlot1 = new Bike_Slot("B1");
        Slot carSlot1 = new Car_Slot("C1");
        Slot truckSlot1 = new Truck_Slot("T1");

        admin.addSlot(f1, bikeSlot1);
        admin.addSlot(f2, carSlot1);
        admin.addSlot(f3, truckSlot1);

        System.out.println("Parking lot address: " + parkingLot.getAddress().toString());
        System.out.println("Is Parking Slot available for Bike: " + parkingLot.isParkingSlotAvailable(VehicleType.BIKE));

        Vehicle bike = new Bike_Vehicle("BR20AZ1234");
        Ticket t1 = gate1.generateTicket(bike);
        System.out.println("Ticket details: " + t1.toString());

        Payment p1 = gate2.processPayment(PaymentType.CARD, t1,new HourlyPaymentStrategy());


    }
}