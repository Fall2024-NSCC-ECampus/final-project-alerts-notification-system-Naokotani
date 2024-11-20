package com.example.alerts.dto.person_info;

import com.example.alerts.model.Address;
import lombok.Data;

@Data
public class PersonInfoPersonDto {
   private String firstName;
   private String lastName;
   private String phone;
   private String fullAddress;
}