package com.example.alerts.dto;
import lombok.Data;
import java.util.List;

@Data
public class ChildAlertDto {
    List<PersonDto> children;
    List<PersonDto> adults;

    public ChildAlertDto(List<PersonDto> children, List<PersonDto> adults) {
        this.children = children;
        this.adults = adults;
    }
}
