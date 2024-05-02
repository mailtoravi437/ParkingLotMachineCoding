package org.example.Model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ContactInfo {
    private String name;
    private String email;
    private String phone;
    private Address address;

}
