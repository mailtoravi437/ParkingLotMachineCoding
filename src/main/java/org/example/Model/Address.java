package org.example.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String addressLine1;
    private String getAddressLine2;
    private String city;
    private String state;
    private String country;
    private String zipCode;
}
