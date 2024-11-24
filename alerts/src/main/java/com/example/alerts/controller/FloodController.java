package com.example.alerts.controller;

import com.example.alerts.dto.flood.FloodDto;
import com.example.alerts.dto.flood.FloodPersonDto;
import com.example.alerts.exception.ResourceNotFound;
import com.example.alerts.mapper.FloodMapper;
import com.example.alerts.model.Address;
import com.example.alerts.model.FireStation;
import com.example.alerts.model.Person;
import com.example.alerts.repository.AddressRepository;
import com.example.alerts.repository.FireStationRepository;
import com.example.alerts.repository.PersonRepository;
import com.example.alerts.service.FloodService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This should return a list of all the households in each fire station’s
 * jurisdiction. This list needs to group people by household address, including
 * name, phone number, and age of each person, and any medications (with dosages)
 * and allergies beside each person’s name.
*/

@RestController
@RequestMapping("/flood")
public class FloodController {
    private final FloodService floodService;
    public FloodController(FloodService floodService) {
        this.floodService = floodService;
    }

    @GetMapping
    public ResponseEntity<List<FloodDto>> getFloodHouseholds(@RequestParam List<Long> stations) {
        List<FloodDto> floodDto = floodService.getFloodHouseholds(stations);
        return new ResponseEntity<>(floodDto, HttpStatus.OK);
    }
}
