package org.example.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.Enums.VehicleType;


@Data
@AllArgsConstructor
public abstract class Vehicle {
    private String vehicleNumber;
    private VehicleType vehicleType;
}
