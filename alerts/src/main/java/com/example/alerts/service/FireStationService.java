package com.example.alerts.service;

import com.example.alerts.dto.person_info.FireStationDto;

public interface FireStationService {
    FireStationDto getPeopleByFirestation(Long stationNumber);
}
