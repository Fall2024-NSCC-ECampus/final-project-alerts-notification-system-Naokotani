package com.example.alerts.service;

import com.example.alerts.dto.flood.FloodDto;

import java.util.List;

public interface FloodService {
    List<FloodDto> getFloodHouseholds(List<Long> stationIds);
}
