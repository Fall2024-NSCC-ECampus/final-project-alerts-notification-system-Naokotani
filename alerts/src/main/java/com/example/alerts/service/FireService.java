package com.example.alerts.service;

import com.example.alerts.dto.AddressDto;
import com.example.alerts.dto.fire.FireDto;

import java.util.List;

public interface FireService {
    List<FireDto> getFireList(AddressDto addressDto);
}
