package com.example.alerts.dto.fire;

import com.example.alerts.dto.AllergyDto;
import com.example.alerts.dto.MedicationDto;
import lombok.Data;

import java.util.List;

@Data
public class FireDto {
    private String fullName;
    private String phoneNumber;
    private int age;
    private String fullAddress;
    private List<MedicationDto> medications;
    private List<AllergyDto> allergies;
}
