package com.example.alerts.dto.flood;

import lombok.Data;

import java.util.List;

@Data
public class FloodDto {
    private String fullAddress;
    private List<FloodPersonDto> household;
}
